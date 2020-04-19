package com.example.groceryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.Objects;

public class GroceryItem extends AppCompatActivity {
    /*private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;*/
    private static final String TAG = "GroceryItem";
    private static final int RC_SIGN_IN = 9001 ;
    private TextView textView, textView2;

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mPrices = new ArrayList<>();
    GoogleSignInClient mGoogleSignInClient;

    public GroceryItem() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        textView = findViewById(R.id.txtItem);
        textView2 = findViewById(R.id.edPrice);

        //mNames = Objects.requireNonNull(getIntent().getExtras()).getStringArrayList("value");
        //textView.setText((CharSequence) mNames);



        mNames();


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Set the dimensions of the sign-in button.
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        //signInButton.setSize(SignInButton.SIZE_STANDARD);

    }
    private void mNames(){

        Log.d(TAG, "mNames: items.");

        mNames.add("Bread");
        mPrices.add("500");

        mNames.add("Beverages");
        mPrices.add("3000");

        mNames.add("Pasta");
        mPrices.add("2000");

        mNames.add("Flakes");
        mPrices.add("1000");

        mNames.add("Chicken");
        mPrices.add("2500");

        mNames.add("Fruits");
        mPrices.add("1000");

        mNames.add("Fresh tomatoes");
        mPrices.add("300");

        mNames.add("Veggies");
        mPrices.add("500");

        mNames.add("Cookies");
        mPrices.add("1000");

        mNames.add("Total");
        mPrices.add("11800");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        GroceryAdapter adapter = new GroceryAdapter(mNames, mPrices, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.share_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sign_in_button:
                signIn();

            case R.id.whatsapp:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }

    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(account);

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("vvvvvvv", "signInResult:failed code=" + e.getStatusCode());
//            updateUI(null);
        }
    }

   /* @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = mGoogleSignInClient.getAccount();
        updateUI(account);
    }*/

    private void updateUI(GoogleSignInAccount account) {
    }
}
