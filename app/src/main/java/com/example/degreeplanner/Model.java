package com.example.degreeplanner;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;

public class Model extends AppCompatActivity implements Contract.Model {
    FirebaseAuth fAuth = FirebaseAuth.getInstance();
    ListenerRegistration listenerRegistration;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;
    //static boolean num;
    Presenter presenter;

    public int login_btn(String email, String password) {
        System.out.println("ge");

        //fAuth.getCurrentUser();
        System.out.println("gj0000000000ute");
        fAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(authResult -> {
            System.out.println("gjgjyfhyeteyteute");
            if (fAuth.getCurrentUser() != null) {
                FirebaseFirestore.getInstance().collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
                DocumentReference df = FirebaseFirestore.getInstance().collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());

                EventListener<DocumentSnapshot> eventListener = new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(DocumentSnapshot snapshot, FirebaseFirestoreException e) {
                        if (snapshot != null && snapshot.exists()) {
                            if (snapshot.getString("isAdmin") != null) {
                                //num=true;
                                Presenter.setNum(1);
                                System.out.println("num=1" + Presenter.getNum());
                            } else if (snapshot.getString("isStudent") != null) {
                                //num = false;
                                Presenter.setNum(2);
                                System.out.println("num=2" + Presenter.getNum());

                            }
                        }
                    }
                };
                listenerRegistration = df.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

                    }


                });


//                       df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                           @Override
//                           public void onSuccess(DocumentSnapshot document) {
////                               if (task.isSuccessful()) {
////                                   DocumentSnapshot document = task.getResult();
//                               if (document != null) {
//                                   if (document.getString("isAdmin") != null) {
//                                       //num=true;
//                                       Presenter.setNum(1);
//
//
//                                       System.out.println("num=1" + Presenter.getNum());
//                                   } else if (document.getString("isStudent") != null) {
//                                       //num = false;
//                                       Presenter.setNum(2);
//                                       System.out.println("num=2" + Presenter.getNum());
//
//                                   }
//                                   else{
//                                       Presenter.setNum(-1);
//                                   }
//
//                               }
//                           }
//                           });

            }

        });
        //FirebaseAuth.getInstance().signOut();

        //return num;

        return Presenter.getNum();
//            if (Presenter.getNum() ==1)
//            {
//                return 1;
//            }
//            else if (Presenter.getNum()==2)
//            {
//                return 2;
//            }
//            else if (Presenter.getNum()==-1)
//            {
//                return -1;
//            }
//            return 0;

    }


    @Override
    public void onStop() {
        super.onStop();
        listenerRegistration.remove();
    }

}



//    public void addtoArrL() {
//        FirebaseFirestore.getInstance().collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()) {
//                    email_id = new ArrayList<>();
//                    for (QueryDocumentSnapshot document : task.getResult()) {
//                        String em = document.getString("email");
//                        email_id.add(em);
//                    }
////
//                } else {
//                    Log.d(TAG, "get failed with ", task.getException());
//                }
//            }
//        });
//    }
//
//
//
//    public boolean ru_there(String email) {
//        addtoArrL();
//        boolean x = false;
//        for (int i = 0; i < email_id.size(); i++) {
//            if (email_id.get(i) == email) {
//                x = true;
//            }
//        }
//        return x;
//    }
//
//    public int data(String email) {
////        if (ru_there(email) == true) {
//        FirebaseFirestore.getInstance().collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
//        DocumentReference df = FirebaseFirestore.getInstance().collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
//        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    if (document != null) {
//                        if (document.getString("isAdmin") != null) {
//                            presenter.num = 1;
//                        } else if (document.getString("isStudent") != null) {
//                            presenter.num = 0;
//                        }
//                    }
//
//                }
//            }
//
//        });
//        return presenter.num;
//
//    }
//}
//
//



















































//    public boolean check_null(){
//        return FirebaseAuth.getInstance().getCurrentUser()==null;
//    }



//    public ArrayList<Integer> Userfield(String email, String password) {
//        DocumentReference docRef = mDb.collection("users").document("isAdmin");
//        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
////                if (task.isSuccessful()) {
////                    DocumentSnapshot document = task.getResult();
////                    if (document.getString("isAdmin") != null) {
////
////
////                    }
////                }
//            }
//        });
//        return Num;

//        public void is(String e, String p){
//
//            FirebaseFirestore.getInstance().collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()) {
//                    email_id = new ArrayList<>();
//                    for (QueryDocumentSnapshot document : task.getResult()) {
//                        String em = document.getString("email");
//                        email_id.add(em);
//                    }
//                    EmailArray = new String[email_id.size()];
//                    EmailArray = email_id.toArray(EmailArray);
//                } else {
//                    Log.d(TAG, "get failed with ", task.getException());
//                }
//            }
//        });
//        }







//       email = presenter.get_email();
//       password = presenter.get_pass();

//        fAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(authResult -> {
//            Num.add(1);
//            if (FirebaseAuth.getInstance().getCurrentUser() != null) {
//                DocumentReference df = FirebaseFirestore.getInstance().collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
//                df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                    @Override
//                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                        if (documentSnapshot.getString("isAdmin") != null) {
//                            Num.add(1);
//                        } else if (documentSnapshot.getString("isStudent") != null) {
//                            Num.add(0);
//                        } else {
//                            Num.add(-1);
//                        }
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        FirebaseAuth.getInstance().signOut();
//                        Num.add(2);
//                    }
//                });
//
//
//            }
//        });
//        return Num;




//    public void Reset_pass(String mail) {
//        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(unused -> Toast.makeText(View2.this, "Reset Link has been sent to your email", Toast.LENGTH_SHORT).show()).addOnFailureListener(e -> Toast.makeText(Login.this, "Error ! No link has been sent" + e.getMessage(), Toast.LENGTH_SHORT).show());
//
//
//    }


//





//
//    EditText mEmail, mPassword;
//    Button mLoginBtn;
//    TextView mCreateBtn, forgotTextLink;
//    ProgressBar progressBar;
//    FirebaseAuth fAuth = FirebaseAuth.getInstance();
//    FirebaseFirestore fStore;
//    ArrayList<String> email_id;
//    String[] EmailArray;
//    int num;
//
//
//
//



//
//
//        public int login_btn (String email, String password) {
////            EditText mEmail = findViewById(R.id.Email);
////            EditText mPassword = findViewById(R.id.password);
////            String email = mEmail.getText().toString().trim();
////            String password =
////            fAuth= FirebaseAuth.getInstance();
//            fAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(authResult -> {
////                Toast.makeText(Model.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
//               // if (fAuth.getCurrentUser() != null) {
//                    //FirebaseFirestore.getInstance().collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
//                DocumentReference df = FirebaseFirestore.getInstance().collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
//                    df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                        @Override
//                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                            if(task.isSuccessful()){
//                                DocumentSnapshot document = task.getResult();
//                                if(document != null){
//                                    if(document.getString("isAdmin") != null){
//                                        num = 1;
//                                    }
//                                    else if(document.getString("isStudent") != null){
//                                        num = 0;
//                                    }
//                                    else{
//                                        num = -1;
//                                    }
//
//                                }
//                            }
//                        }
//                    });
////                    {
////
//                //}
//            });
//            return num;
//    }
//
//        public void forgott(){
//        forgotTextLink.setOnClickListener(view -> {
//            EditText resetMail = new EditText(view.getContext());
//            AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
//            passwordResetDialog.setTitle("Reset Password?");
//            passwordResetDialog.setMessage("Enter your email id to receive the reset link");
//            passwordResetDialog.setView(resetMail);
//            passwordResetDialog.setPositiveButton("Yes", (dialogInterface, i) -> {
//                String mail = resetMail.getText().toString();
//                fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(unused -> Toast.makeText(Model.this, "Reset Link has been sent to your email", Toast.LENGTH_SHORT).show()).addOnFailureListener(e -> Toast.makeText(Model.this, "Error ! No link has been sent" + e.getMessage(), Toast.LENGTH_SHORT).show());
//            });
//            passwordResetDialog.setNegativeButton("No", (dialogInterface, i) -> {
//
//            });
//            passwordResetDialog.create().show();
//        });
//
//        }
//
//
//
//}
//
//
//