package org.nearbyshops.enduserappnew.Markets;

import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.nearbyshops.enduserappnew.API_SDS.ServiceConfigService;
import org.nearbyshops.enduserappnew.DaggerComponentBuilder;
import org.nearbyshops.enduserappnew.MyApplication;
import org.nearbyshops.enduserappnew.Preferences.PrefServiceConfig;
import org.nearbyshops.enduserappnew.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Inject;



public class SubmitURLDialog extends DialogFragment implements View.OnClickListener {


    ImageView dismiss_dialog_button;
    TextView cancel_button;
    TextView submit_button;
    EditText service_url;
//    EditText password;

    ProgressBar progressBar;

    TextView createMarketMessage;

//    @Inject
//    ServiceConfigService serviceConfigService;



    @Inject Gson gson;




    public SubmitURLDialog() {
        super();

        DaggerComponentBuilder.getInstance()
                .getNetComponent()
                .Inject(this);
    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.dialog_submit_url_new, container);

        dismiss_dialog_button = (ImageView) view.findViewById(R.id.dialog_dismiss_icon);
        cancel_button = (TextView) view.findViewById(R.id.cancel_button);
        submit_button = (TextView) view.findViewById(R.id.submit_button);
        service_url = (EditText) view.findViewById(R.id.service_url);
//        password = (EditText) view.findViewById(R.id.password);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);

        createMarketMessage = view.findViewById(R.id.create_market_message);



        createMarketMessage.setOnClickListener(this);
        cancel_button.setOnClickListener(this);
        submit_button.setOnClickListener(this);
        dismiss_dialog_button.setOnClickListener(this);

        return view;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = super.onCreateDialog(savedInstanceState);
        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.dialog_dismiss_icon:

                dismiss();
                Toast.makeText(getActivity(), R.string.dialog_dismissed,Toast.LENGTH_SHORT).show();

                break;

            case R.id.submit_button:

                submit_click();

                break;

            case R.id.cancel_button:

                signUp_click();

                break;


            case R.id.create_market_message:


                createMarketMessage();

                break;

            default:
                break;
        }

    }





    private void createMarketMessage()
    {
        String url = "https://nearbyshops.org/entrepreneur.html";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }







    private void submit_click()
    {


        if(service_url.getText().toString().length()==0)
        {
            service_url.setError("Enter service url !");
            service_url.requestFocus();

            return;
        }


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(PrefServiceConfig.getServiceURL_SDS(MyApplication.getAppContext()))
                .client(new OkHttpClient().newBuilder().build())
                .build();


        Call<ResponseBody> call = retrofit.create(ServiceConfigService.class).saveService(service_url.getText().toString());

        progressBar.setVisibility(View.VISIBLE);
        submit_button.setVisibility(View.INVISIBLE);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if(!isVisible())
                {
                    return;
                }

                if(response.code()==200)
                {
                    showToastMessage("Updated Successfully !");
                }
                else if(response.code()==201)
                {
                    showToastMessage("Added Successfully !");
                }
                else
                {
                    showToastMessage("Failed ... Error Code : " + String.valueOf(response.code()));
                }

                progressBar.setVisibility(View.INVISIBLE);
                submit_button.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                if(!isVisible())
                {
                    return;
                }



                progressBar.setVisibility(View.INVISIBLE);
                submit_button.setVisibility(View.VISIBLE);
                showToastMessage("Failed !");
            }
        });
    }





    private void showToastMessage(String message)
    {
        Toast.makeText(getActivity(),message, Toast.LENGTH_SHORT).show();
    }









    private void signUp_click()
    {
//        Intent intent = new Intent(getContext(),SignUp.class);
//        startActivity(intent);


        ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
//        ClipData clip = ClipData.newPlainText("URL", serviceURL.getText().toString());
//        clipboard.setPrimaryClip(clip);


        if(clipboard.getPrimaryClip()!=null)
        {
            service_url.setText(clipboard.getPrimaryClip().getItemAt(0).getText());
        }



//        dismiss();
    }

}
