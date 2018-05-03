package com.example.android.quidditchcounter;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int team_a_score = 0;
    int team_b_score = 0;
    int selected_teams = 0;
    int end_game = 0;
    String team_a_name = "";
    String team_b_name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * switches background to gryffindor_crest
     */
    public void select_gryffindor(View view) {
        if (end_game == 0) {
            if (selected_teams == 0) {
                LinearLayout home_layout = (LinearLayout) findViewById(R.id.home_team_bg);
                home_layout.setBackgroundResource(R.drawable.gryffindor_crest);
                selected_teams += 1;
                changeCenterButtonPhrase("Select Away Team");
                team_a_name = "Gryffindor";
            } else if (selected_teams == 1) {
                LinearLayout home_layout = (LinearLayout) findViewById(R.id.away_team_bg);
                home_layout.setBackgroundResource(R.drawable.gryffindor_crest);
                selected_teams += 1;
                hideTeams();
                showButtons();
                showScores();
                changeCenterButtonPhrase("Reset");
                team_b_name = "Gryffindor";
            }
        }
    }
    /**
     *
     * switches background to hufflepuff_crest
     */
    public void select_hufflepuff(View view) {
        if (end_game == 0) {
            if (selected_teams == 0) {
                LinearLayout home_layout = (LinearLayout) findViewById(R.id.home_team_bg);
                home_layout.setBackgroundResource(R.drawable.hufflepuff_crest);
                selected_teams += 1;
                changeCenterButtonPhrase("Select Away Team");
                team_a_name = "Hufflepuff";
            } else if (selected_teams == 1) {
                LinearLayout home_layout = (LinearLayout) findViewById(R.id.away_team_bg);
                home_layout.setBackgroundResource(R.drawable.hufflepuff_crest);
                selected_teams += 1;
                hideTeams();
                showButtons();
                showScores();
                changeCenterButtonPhrase("Reset");
                team_b_name = "Hufflepuff";
            }
        }
    }
    /**
     *
     * switches background to ravenclaw_crest
     */
    public void select_ravenclaw(View view) {
        if (end_game == 0) {
            if (selected_teams == 0) {
                LinearLayout home_layout = (LinearLayout) findViewById(R.id.home_team_bg);
                home_layout.setBackgroundResource(R.drawable.ravenclaw_crest);
                selected_teams += 1;
                changeCenterButtonPhrase("Select Away Team");
                team_a_name = "Ravenclaw";
            } else if (selected_teams == 1) {
                LinearLayout home_layout = (LinearLayout) findViewById(R.id.away_team_bg);
                home_layout.setBackgroundResource(R.drawable.ravenclaw_crest);
                selected_teams += 1;
                hideTeams();
                showButtons();
                showScores();
                changeCenterButtonPhrase("Reset");
                team_b_name = "Ravenclaw";
            }
        }
    }
    /**
     *
     * switches background to slytherin_crest
     */
    public void select_slytherin(View view) {
        if (end_game == 0) {
            if (selected_teams == 0) {
                LinearLayout home_layout = (LinearLayout) findViewById(R.id.home_team_bg);
                home_layout.setBackgroundResource(R.drawable.slytherin_crest);
                selected_teams += 1;
                changeCenterButtonPhrase("Select Away Team");
                team_a_name = "Slytherin";
            } else if (selected_teams == 1) {
                LinearLayout home_layout = (LinearLayout) findViewById(R.id.away_team_bg);
                home_layout.setBackgroundResource(R.drawable.slytherin_crest);
                selected_teams += 1;
                hideTeams();
                showButtons();
                showScores();
                changeCenterButtonPhrase("Reset");
                team_b_name = "Slytherin";
            }
        }
    }
    /**
     * hides the select team buttons when both teams are selected
     */
    public void hideTeams() {
        Button hide_me = (Button) findViewById(R.id.button_gryffindor);
        hide_me.setVisibility(hide_me.GONE);
        hide_me = findViewById(R.id.button_hufflepuff);
        hide_me.setVisibility(hide_me.GONE);
        hide_me = findViewById(R.id.button_ravenclaw);
        hide_me.setVisibility(hide_me.GONE);
        hide_me = findViewById(R.id.button_slytherin);
        hide_me.setVisibility(hide_me.GONE);
    }
    /**
     * shows the select team buttons when both teams are selected
     */
    public void showTeams() {
        Button show_me = (Button) findViewById(R.id.button_gryffindor);
        show_me.setVisibility(show_me.VISIBLE);
        show_me = findViewById(R.id.button_hufflepuff);
        show_me.setVisibility(show_me.VISIBLE);
        show_me = findViewById(R.id.button_ravenclaw);
        show_me.setVisibility(show_me.VISIBLE);
        show_me = findViewById(R.id.button_slytherin);
        show_me.setVisibility(show_me.VISIBLE);
    }
    /**
     * show both team scores
     */
    public void showScores() {
        TextView show_me = (TextView) findViewById(R.id.home_score);
        show_me.setVisibility(show_me.VISIBLE);
        show_me = (TextView) findViewById(R.id.away_score);
        show_me.setVisibility(show_me.VISIBLE);
    }
    /**
     * hide both team scores
     */
    public void hideScores() {
        TextView hide_me = (TextView) findViewById(R.id.home_score);
        hide_me.setVisibility(hide_me.INVISIBLE);
        hide_me = (TextView) findViewById(R.id.away_score);
        hide_me.setVisibility(hide_me.INVISIBLE);
    }
    /**
     * show both team quaffle and snitch buttons
     */
    public void showButtons() {
        Button show_me = (Button) findViewById(R.id.home_quaffle);
        show_me.setVisibility(show_me.VISIBLE);
        show_me = (Button) findViewById(R.id.away_quaffle);
        show_me.setVisibility(show_me.VISIBLE);
        show_me = (Button) findViewById(R.id.away_snitch);
        show_me.setVisibility(show_me.VISIBLE);
        show_me = (Button) findViewById(R.id.home_snitch);
        show_me.setVisibility(show_me.VISIBLE);
    }
    /**
     * show both team quaffle and snitch buttons
     */
    public void hideButtons() {
        Button hide_me = (Button) findViewById(R.id.home_quaffle);
        hide_me.setVisibility(hide_me.INVISIBLE);
        hide_me = (Button) findViewById(R.id.away_quaffle);
        hide_me.setVisibility(hide_me.INVISIBLE);
        hide_me = (Button) findViewById(R.id.away_snitch);
        hide_me.setVisibility(hide_me.INVISIBLE);
        hide_me = (Button) findViewById(R.id.home_snitch);
        hide_me.setVisibility(hide_me.INVISIBLE);
    }
    /**
     * change select team text to RESET
     */
    public void changeCenterButtonPhrase(String string) {
        Button change_me = (Button) findViewById(R.id.reset_button);
        change_me.setText(string);
    }
    /**
     * adds 10 pts to home_team on click
     */
    public void add_10_home (View view) {
        if (end_game == 0) {
            team_a_score += 10;
            display_home_score(team_a_score);
        }
    }
    /**
     * adds 10 pts to away_team on click
     */
    public void add_10_away (View view) {
        if (end_game == 0) {
            team_b_score += 10;
            display_away_score(team_b_score);
        }
    }
    /**
     * adds 150 pts to home_team on click
     */
    public void add_150_home (View view) {
        if (end_game == 0) {
            team_a_score += 150;
            display_home_score(team_a_score);
            end_game += 1;
            win_result();
        }
    }
    /**
     * adds 150 pts to away_team on click
     */
    public void add_150_away (View view) {
        if (end_game == 0) {
            team_b_score += 150;
            display_away_score(team_b_score);
            end_game += 1;
            win_result();
        }
    }
    /**
     * team with higher points wins
     */
    public void win_result() {
        if (team_a_score > team_b_score)
            winner("Home Team\n" + team_a_name);
        else
            winner("Away Team\n" + team_b_name);
    }
    /**
     * display home_score on screen
     */
    public void display_home_score(int score){
        TextView show_me = (TextView)findViewById(R.id.home_score);
        show_me.setText(String.valueOf(score));
    }
    /**
     * display away_score on screen
     */
    public void display_away_score(int score){
        TextView show_me = (TextView)findViewById(R.id.away_score);
        show_me.setText(String.valueOf(score));
    }
    /**
     * show win msg
     */
    public void winner(String team) {
        hideButtons();
        TextView win_msg = (TextView) findViewById(R.id.win_msg);
        win_msg.setTextColor(Color.WHITE);
        win_msg.setTextSize(42);
        win_msg.setText(team + " wins!");
        win_msg.setVisibility(View.VISIBLE);
    }
    /**
     * resets scores to 0, shows teams, hides pts, resets bgs, hides win_msg
     */
    public void reset_all(View view) {
        showTeams();
        team_a_score = 0;
        team_b_score = 0;
        display_home_score(0);
        display_away_score(0);
        hideScores();
        selected_teams = 0;
        end_game = 0;
        changeCenterButtonPhrase("Select Home Team");
        hideButtons();
        LinearLayout home_layout = (LinearLayout) findViewById(R.id.home_team_bg);
        home_layout.setBackgroundResource(0);
        home_layout = (LinearLayout) findViewById(R.id.away_team_bg);
        home_layout.setBackgroundResource(0);
        TextView win_msg = (TextView) findViewById(R.id.win_msg);
        win_msg.setVisibility(View.INVISIBLE);
    }
}
