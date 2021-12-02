package com.example.traveldemo.account;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.example.traveldemo.databinding.FragmentSignupBinding;
import com.example.traveldemo.firebaseverify.EnterOtpActivity;
import com.example.traveldemo.firebaseverify.VerifyPhoneNumberActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class SignupFragment extends Fragment {
    private FragmentSignupBinding binding;
    private float v =0;
    private ProgressDialog progressDialog;
    public static SignupFragment newInstance() {

        Bundle args = new Bundle();

        SignupFragment fragment = new SignupFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup,container,false);
        animateView();
        binding.btnOfPanelLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(LoginFragment.newInstance());
            }
        });
        progressDialog = new ProgressDialog(getContext());
        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickSignUp();
            }
        });
        return binding.getRoot();
    }

    private void onClickSignUp() {
        String email = binding.edUsername.getText().toString().trim();
        String password = binding.edPassword.getText().toString().trim();
        String confirm = binding.edConfirmPassword.getText().toString().trim();
        progressDialog.show();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            startActivity(intent);
                            getActivity().finishAffinity();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getActivity(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void getFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.container_sign_in,fragment).commit();
    }
    private void animateView(){
        binding.viewUsername.setTranslationX(800);
        binding.viewPassword.setTranslationX(800);
        binding.viewConfirmPassword.setTranslationX(800);
        binding.viewPhoneNumber.setTranslationX(800);
        binding.btnSignup.setTranslationX(800);

        binding.viewUsername.setAlpha(v);
        binding.viewPassword.setAlpha(v);
        binding.viewConfirmPassword.setAlpha(v);
        binding.viewPhoneNumber.setAlpha(v);
        binding.btnSignup.setAlpha(v);

        binding.viewUsername.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(200).start();
        binding.viewPassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(400).start();
        binding.viewConfirmPassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(600).start();
        binding.viewPhoneNumber.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(800).start();
        binding.btnSignup.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1000).start();

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
