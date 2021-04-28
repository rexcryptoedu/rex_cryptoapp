package com.cursoandroidstudio.rexcryptoeducation.fragment;

import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.cursoandroidstudio.rexcryptoeducation.R;

import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseFragment extends Fragment {

    private TextView textContent;

    //Inicializar variáveis
    private TextView textPosition, textDuration;
    private SeekBar seekPosition;
    private ImageView imageRewind, imagePlay, imagePause, imageForward;

    private MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    Runnable runnable;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CourseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CourseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseFragment newInstance(String param1, String param2) {
        CourseFragment fragment = new CourseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_course, container, false);

        textContent = v.findViewById(R.id.textContent);

        //Atribuir variáveis
        textPosition = v.findViewById(R.id.textPosition);
        textDuration = v.findViewById(R.id.textDuration);
        seekPosition = v.findViewById(R.id.seekPosition);
        imageRewind = v.findViewById(R.id.imageRewind);
        imagePlay = v.findViewById(R.id.imagePlay);
        imagePause = v.findViewById(R.id.imagePause);
        imageForward = v.findViewById(R.id.imageForward);

        //Inicializar media player
        mediaPlayer = MediaPlayer.create(v.getContext(),R.raw.teste);

        //Inicializar runnable
        runnable = new Runnable() {
            @Override
            public void run() {
                //Definir o progresso na seek bar
                seekPosition.setProgress(mediaPlayer.getCurrentPosition());
                //Handler post delay for 0.5 second
                handler.postDelayed( this, 500);
            }
        };

        //Obter duração do media player
        int duration = mediaPlayer.getDuration();
        //Converter milissegundo em minuto e segundo
        String sDuration = convertFormat(duration);
        //Definir a duração no text view
        textDuration.setText(sDuration);

        imagePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ocultar botão de reprodução
                imagePlay.setVisibility(View.GONE);
                //Mostrar botão de pausa
                imagePause.setVisibility(View.VISIBLE);
                //Iniciar media player
                mediaPlayer.start();
                //Definir o máximo na seek bar
                seekPosition.setMax(mediaPlayer.getDuration());
                //Inicializar handler
                handler.postDelayed(runnable, 0);
            }
        });

        imagePause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ocultar botão de pausa
                imagePause.setVisibility(View.GONE);
                //Mostrar botão de reprodução
                imagePlay.setVisibility(View.VISIBLE);
                //Pausar media player
                mediaPlayer.pause();
                //Parar handler
                handler.removeCallbacks(runnable);
            }
        });

        imageForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obter a posição atual do media player
                int currentPosition = mediaPlayer.getCurrentPosition();
                //Obter duração do media player
                int duration = mediaPlayer.getDuration();
                //Verificar condição
                if ( mediaPlayer.isPlaying() && duration != currentPosition){
                    //Quando a mídia está sendo reproduzida e a duração não é igual à posição atual
                    //Avançar 5 segundos
                    currentPosition = currentPosition + 5000;
                    //Definir a posição atual no text view
                    textPosition.setText(convertFormat(currentPosition));
                    //Definir o progresso na seek bar
                    mediaPlayer.seekTo(currentPosition);
                }
            }
        });

        imageRewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obter a posição atual do media player
                int currentPosition = mediaPlayer.getCurrentPosition();
                //Verificar condição
                if ( mediaPlayer.isPlaying() && currentPosition > 5000){
                    //Quando a mídia está sendo reproduzida e a a posição atual é maior que 5 segundos
                    //Rebobinar 5 segundos
                    currentPosition = currentPosition - 5000;
                    //Definir a posição atual no text view
                    textPosition.setText(convertFormat(currentPosition));
                    //Definir o progresso na seek bar
                    mediaPlayer.seekTo(currentPosition);
                }
            }
        });

        seekPosition.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Verificar condição
                if (fromUser){
                    //Ao arrastar a seek bar
                    //Definir o progresso na seek bar
                    mediaPlayer.seekTo(progress);
                }
                //Definir a posição atual no text view
                textPosition.setText(convertFormat(mediaPlayer.getCurrentPosition()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //Ocultar botão de pausa
                imagePause.setVisibility(View.GONE);
                //Mostrar botão de reprodução
                imagePlay.setVisibility(View.VISIBLE);
                //Definir o media player para a posição inicial
                mediaPlayer.seekTo(0);
            }
        });


        textContent.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin consectetur efficitur tortor a dictum. Vestibulum molestie quam vel enim semper, sit amet tristique est iaculis. Morbi aliquet lorem purus, et fermentum elit ultrices in. Aenean suscipit erat dapibus lectus sollicitudin vestibulum. Sed in urna sed ante dapibus lobortis. Nullam scelerisque convallis tortor non semper. Quisque vitae tellus felis. Nullam accumsan elit justo. Praesent condimentum venenatis nibh, tincidunt finibus libero dapibus et. Pellentesque ut euismod ligula, ac pellentesque risus. Sed quam sem, vulputate porttitor molestie sit amet, posuere non dolor. Suspendisse ut vehicula enim, at blandit nisi. Nulla tempus, nisi eget molestie rutrum, lacus ligula lobortis massa, ac facilisis sem sem eu nulla. Cras sed commodo odio.\n" +
                "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In pulvinar ante sit amet molestie posuere. In hac habitasse platea dictumst. Quisque et tempus neque, pretium pharetra enim. Pellentesque id tincidunt ex, sit amet placerat lorem. Nunc accumsan eleifend neque, id facilisis orci pretium suscipit. Nullam at ullamcorper erat.\n" +
                "\n" +
                "Duis nec dictum quam. Curabitur venenatis iaculis lobortis. Duis a faucibus felis, non auctor massa. Suspendisse mattis nec tortor volutpat ornare. Mauris placerat magna eu purus luctus, eu lobortis nisi semper. Etiam dignissim et quam sit amet posuere. Donec ornare arcu arcu, non dictum mi porta a. Pellentesque ultricies velit id ipsum laoreet, ac dapibus erat volutpat. Curabitur quis dui mauris. Aenean consectetur quis ante a vulputate. Mauris lectus dui, posuere vitae arcu at, vulputate rhoncus mauris.\n" +
                "\n" +
                "Praesent maximus faucibus libero, quis faucibus mi porttitor id. Nullam sit amet sapien volutpat, sagittis dui eget, feugiat ligula. Aenean non turpis imperdiet, efficitur elit et, dictum quam. Curabitur feugiat scelerisque varius. Morbi ut tortor et quam pharetra sollicitudin in sit amet est. Sed non iaculis sapien, eu efficitur erat. Curabitur ac nisl ipsum. Morbi mauris lacus, sodales sit amet justo vitae, efficitur viverra dui.\n" +
                "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vel egestas magna. Duis scelerisque purus non metus facilisis, sit amet gravida enim ornare. Aliquam nec convallis est, quis venenatis augue. Suspendisse potenti. Praesent quis felis egestas, luctus sem non, pulvinar mi. Curabitur lobortis sed velit quis egestas. Nunc urna mauris, malesuada sed varius quis, luctus at mauris. Vivamus a justo sed sem pulvinar efficitur quis pharetra lectus. Suspendisse mollis cursus blandit. Etiam eu varius urna. Nullam enim lorem, interdum ut auctor sed, ornare eu lorem. Proin tempus scelerisque dignissim. Mauris vel neque ac libero vehicula iaculis in sed dui. Lorem ipsum dolor sit amet, consectetur adipiscing elit."
        );

        return v;
    }

    private String convertFormat(int duration) {
        return  String.format("%02d:%02d"
                , TimeUnit.MILLISECONDS.toMinutes(duration)
                , TimeUnit.MILLISECONDS.toSeconds(duration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }

}

