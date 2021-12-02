package com.example.traveldemo.account;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.traveldemo.MainActivity;
import com.example.traveldemo.R;
import com.example.traveldemo.databinding.FragmentLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    private float v =0;
    private ProgressDialog progressDialog;
    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false);
        animateView();
        progressDialog = new ProgressDialog(getContext());
        binding.btnOfPanelSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(SignupFragment.newInstance());
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSignIn();
            }
        });
        return binding.getRoot();
    }
    private void onClickSignIn() {
        String email = binding.edUsername.getText().toString().trim();
        String password = binding.edPassword.getText().toString().trim();
        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(getContext(), "Nhập đi",
                    Toast.LENGTH_SHORT).show();
        }else {
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            progressDialog.show();
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                startActivity(intent);
                                getActivity().finishAffinity();
                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(getContext(), password,
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }

    }



    public void getFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.container_sign_in,fragment).commit();
    }

    private void animateView(){
        binding.tvFillTheForm.setTranslationX(800);
        binding.viewUsername.setTranslationX(800);
        binding.viewPassword.setTranslationX(800);
        binding.tvForgotPassword.setTranslationX(800);
        binding.btnLogin.setTranslationX(800);

        binding.tvFillTheForm.setAlpha(v);
        binding.viewUsername.setAlpha(v);
        binding.viewPassword.setAlpha(v);
        binding.tvForgotPassword.setAlpha(v);
        binding.btnLogin.setAlpha(v);

        binding.tvFillTheForm.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(200).start();
        binding.viewUsername.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(400).start();
        binding.viewPassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(600).start();
        binding.tvForgotPassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(800).start();
        binding.btnLogin.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1000).start();

        binding.iconFacebook.setTranslationY(300);
        binding.iconInstagram.setTranslationY(300);
        binding.iconTwitter.setTranslationY(300);
        binding.iconContact.setTranslationY(300);

        binding.iconFacebook.setAlpha(v);
        binding.iconInstagram.setAlpha(v);
        binding.iconTwitter.setAlpha(v);
        binding.iconContact.setAlpha(v);

        binding.iconFacebook.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        binding.iconInstagram.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        binding.iconTwitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(900).start();
        binding.iconContact.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(1000).start();
    }
}
