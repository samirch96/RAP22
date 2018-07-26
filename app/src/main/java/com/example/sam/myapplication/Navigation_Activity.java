package com.example.sam.myapplication;

public class Navigation_Activity
        {}

  /*  TextView nav_header_nam, nav_header_emal;
    ImageView nav_header_imag;
    public final static String Message = "com.example.sam.myapplication.MESSAGE";
    Button c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    private ProgressDialog progressBar;
    MediaPlayer mediaPlayer;
    CardView catg1,catg2;
    ViewFlipper viewFlipper;
    Button b1,b2;
    static  int Catg_id=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences sharedPreferences = getSharedPreferences("Content_main", Context.MODE_PRIVATE);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);*/
        //To play background sound
        /*if (sp.getInt("Sound", 0) == 0) {
            mediaPlayer = MediaPlayer.create(this, R.raw.song);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }*/
/*
        //Set name,email,image in  the navigation side drawer to those we enter in the login page
        String nav_header_name = sharedPreferences.getString("name", "xyz");
        String nav_header_email = sharedPreferences.getString("email", "abc@gmail.com");
        String nav_header_gender = sharedPreferences.getString("gender", "Male");
        View header = navigationView.getHeaderView(0);//Used to get a reference to navigation header
        nav_header_nam = (TextView) header.findViewById(R.id.nav_header_name);
        nav_header_emal = (TextView) header.findViewById(R.id.nav_header_email);
        nav_header_imag = (ImageView) header.findViewById(R.id.nav_header_image);
        nav_header_nam.setText(nav_header_name);
        nav_header_emal.setText(nav_header_email);
        if (nav_header_gender.equals("Male")) {
            nav_header_imag.setImageResource(R.drawable.man);
        } else {
            nav_header_imag.setImageResource(R.drawable.female);
        }



        viewFlipper=(ViewFlipper)findViewById(R.id.viewFlipper);
        b1=(Button)findViewById(R.id.btn_next_lv);
        b2=(Button)findViewById(R.id.btn_prev_lv);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showPrevious();
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_scorecard) {
            Intent intent = new Intent(this, ScoreCard.class);
            startActivity(intent);

        } else if (id == R.id.nav_Setting) {
              /*  startActivity(new Intent(this,Setting.class));*/
  /*          startActivity(new Intent(this, Setting_activity.class));

        } else if (id == R.id.nav_share) {
            //shareApplication();
            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_SUBJECT, "QuizBook");
            System.out.println(""+R.string.email_content);
            intent.putExtra(Intent.EXTRA_TEXT, ""+getText(R.string.email_content)+getText(R.string.link)+getText(R.string.last_content));
            Intent chooser = Intent.createChooser(intent, "Share using");
            startActivity(chooser);


        } else if (id == R.id.nav_share1) {
            Intent i = new Intent(getApplicationContext(),ShaireScoreActivity.class);
            startActivity(i);
        }else if (id == R.id.nav_feedback) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] recipents = {"kvikesh800@gmail.com"};
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, recipents);
            intent.putExtra(Intent.EXTRA_SUBJECT, "QuizBook Reviews");
            Intent chooser = Intent.createChooser(intent, "Send Feedback Via");
            startActivity(chooser);

        } else if (id == R.id.nav_Help) {
            Intent i = new Intent(this, Help.class);
            startActivity(i);

        } else if (id == R.id.nav_aboutus) {
            Intent i = new Intent(this, AboutUs.class);
            startActivity(i);
        }else if (id == R.id.random) {
            Intent i = new Intent(this, RandomActivity.class);
            startActivity(i);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
/*
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.start();
    }*/
/*
    public void catg1(View v){Catg_id =1 ; Intent i = new Intent(Navigation_Activity.this, Catg1LsActivity.class);startActivity(i);}
    public void catg2(View v){Catg_id =2 ; Intent i = new Intent(Navigation_Activity.this, Catg2LsActivity.class);startActivity(i);}
    public void catg3(View v){Catg_id =3 ; Intent i = new Intent(Navigation_Activity.this, Catg3LsActivity.class);startActivity(i);}
    public void catg4(View v){Catg_id =4 ; Intent i = new Intent(Navigation_Activity.this, Catg4LsActivity.class);startActivity(i);}
    public void catg5(View v){Catg_id =5 ; Intent i = new Intent(Navigation_Activity.this, Catg5LsActivity.class);startActivity(i);}
    public void catg6(View v){Catg_id =6 ; Intent i = new Intent(Navigation_Activity.this, Catg6LsActivity.class);startActivity(i);}
    public void catg7(View v){Catg_id =7 ; Intent i = new Intent(Navigation_Activity.this, Catg7LsActivity.class);startActivity(i);}
    public void catg8(View v){Catg_id =8 ; Intent i = new Intent(Navigation_Activity.this, Catg8LsActivity.class);startActivity(i);}
    public void catg9(View v){Catg_id =9 ; Intent i = new Intent(Navigation_Activity.this, Catg9LsActivity.class);startActivity(i);}
}*/

