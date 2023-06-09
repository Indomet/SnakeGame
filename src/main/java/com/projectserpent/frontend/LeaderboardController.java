package com.projectserpent.frontend;

import com.projectserpent.backend.LeaderboardList;
import com.projectserpent.backend.UserScore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/***
 * Controller for leaderboard.
 */

public class LeaderboardController extends DeathScreenController {
    @FXML
    public TableView<UserScore> leaderboardTable;
    @FXML
    public TableColumn<String, Integer> scoreColumn;
    @FXML
    public TableColumn<String, String> nameColumn;
    private final LeaderboardList leaderboard = DeathScreenController.leaderboard;
    public ImageView backButtonNormal, backButtonPressed;
    public ImageView newGameButtonNormal, newGameButtonPressed;
    public Label titleLabel;
    public Label nameOne, nameTwo, nameThree, nameFour, nameFive, nameSix, nameSeven, nameEight, nameNine, nameTen;
    public Label scoreOne, scoreTwo, scoreThree, scoreFour, scoreFive, scoreSix, scoreSeven, scoreEight, scoreNine, scoreTen;

    //Initializes leaderboard and hover animation logic
    @FXML
    public void initialize() {
        loadLeaderboard();
        backButtonPressed.setVisible(false);
        newGameButtonPressed.setVisible(false);
        loadNameColumn();
        loadScoreColumn();
    }
    //Method is called when "Main Menu" button is pressed.
    @FXML
    public void switchToMainMenu(MouseEvent event) throws IOException {
        sceneSwitch(event, "main-menu.fxml");
    }
    //Method is called when "Start Game" button is pressed-
    @FXML
    public void startGame(MouseEvent event) throws IOException {
        sceneSwitch(event, "game-screen.fxml");
    }
    //Part of logic to display leaderboard.
    @FXML
    public void loadLeaderboard() {
        ObservableList<UserScore> items = FXCollections.observableArrayList();
        convertToObservable(items);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        leaderboardTable.setItems(items);
    }
    //Part of logic to display leaderboard.
    @FXML
    public void convertToObservable(ObservableList<UserScore> list)  {
        list.addAll(leaderboard.getLeaderboard());
    }
    /*
    Hover animation methods
     */
    public void hoverBackButton(MouseEvent event) {
        backButtonPressed.setVisible(true);
        backButtonNormal.setVisible(false);
    }

    public void stopHoverBackButton(MouseEvent event) {
        backButtonPressed.setVisible(false);
        backButtonNormal.setVisible(true);
    }

    public void hoverNewGameButton(MouseEvent event) {
        newGameButtonPressed.setVisible(true);
        newGameButtonNormal.setVisible(false);
    }

    public void stopHoverNewGameButton(MouseEvent event) {
        newGameButtonPressed.setVisible(false);
        newGameButtonNormal.setVisible(true);
    }

    /*
    Methods loading columns into labels.
     */
    public void loadNameColumn() {
        nameOne.setText(nameColumn.getCellObservableValue(0).getValue());
        nameTwo.setText(nameColumn.getCellObservableValue(1).getValue());
        nameThree.setText(nameColumn.getCellObservableValue(2).getValue());
        nameFour.setText(nameColumn.getCellObservableValue(3).getValue());
        nameFive.setText(nameColumn.getCellObservableValue(4).getValue());
        nameSix.setText(nameColumn.getCellObservableValue(5).getValue());
        nameSeven.setText(nameColumn.getCellObservableValue(6).getValue());
        nameEight.setText(nameColumn.getCellObservableValue(7).getValue());
        nameNine.setText(nameColumn.getCellObservableValue(8).getValue());
        nameTen.setText(nameColumn.getCellObservableValue(9).getValue());

    }
    public void loadScoreColumn() {
        scoreOne.setText(String.valueOf(scoreColumn.getCellObservableValue(0).getValue()));
        scoreTwo.setText(String.valueOf(scoreColumn.getCellObservableValue(1).getValue()));
        scoreThree.setText(String.valueOf(scoreColumn.getCellObservableValue(2).getValue()));
        scoreFour.setText(String.valueOf(scoreColumn.getCellObservableValue(3).getValue()));
        scoreFive.setText(String.valueOf(scoreColumn.getCellObservableValue(4).getValue()));
        scoreSix.setText(String.valueOf(scoreColumn.getCellObservableValue(5).getValue()));
        scoreSeven.setText(String.valueOf(scoreColumn.getCellObservableValue(6).getValue()));
        scoreEight.setText(String.valueOf(scoreColumn.getCellObservableValue(7).getValue()));
        scoreNine.setText(String.valueOf(scoreColumn.getCellObservableValue(8).getValue()));
        scoreTen.setText(String.valueOf(scoreColumn.getCellObservableValue(9).getValue()));
    }
}
