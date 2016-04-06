package armada.project.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

import armada.project.game.DrawUtils;
import armada.project.game.Game;
import armada.project.game.ScoreManager;

public class MainMenuPanel extends GuiPanel {

	private Font titleFont = Game.main.deriveFont(100f);
	private Font creatorFont = Game.main.deriveFont(24f);
	private String title = "2048";
	private String creator = "By Armada Bros.";
	private int buttonWidth = 220;
        private ScoreManager scores;
        private int a=310;
        public static boolean diff=false;
        public GuiButton Resume;
	public GuiButton playButton;	
        public GuiButton scoresButton;
        public GuiButton quitButton ;
	public MainMenuPanel() {
		super(); 
                Resume=new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, 220, buttonWidth, 60);
                playButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, a, buttonWidth, 60);	
                scoresButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, a+90, buttonWidth, 60);
                quitButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, a+180, buttonWidth, 60);
                Resume.addActionListener((ActionEvent e) -> {
                    GuiScreen.getInstance().setCurrentPanel("Play");
                });
                Resume.setText("Resume");
                add(Resume);
                playButton.addActionListener((ActionEvent e) -> {
                    diff=true;
                    GuiScreen.getInstance().setCurrentPanel("Difficulty");
                });
                playButton.setText("Play");
                add(playButton);
                scoresButton.addActionListener((ActionEvent e) -> {
                    GuiScreen.getInstance().setCurrentPanel("Leaderboards");
                });
		scoresButton.setText("Scores");
		add(scoresButton);
		quitButton.addActionListener((ActionEvent e) -> {
                    System.exit(0);
                });
		quitButton.setText("Quit");
		add(quitButton);
	}
        @Override
        public void update(){    
        }
	@Override
	public void render(Graphics2D g){
		super.render(g);
		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString(title, Game.WIDTH / 2 - DrawUtils.getMessageWidth(title, titleFont, g) / 2, 150);
		g.setFont(creatorFont);
		g.drawString(creator, 20, Game.HEIGHT - 10);
	}
        
}
