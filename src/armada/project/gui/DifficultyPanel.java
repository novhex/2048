package armada.project.gui;
//User Defined Classes
import armada.project.game.DrawUtils;
import armada.project.game.Game;
import armada.project.game.GameBoard;
//Built-in Classes
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

public class DifficultyPanel extends GuiPanel {
        private Font titleFont = Game.main.deriveFont(72f);
	private String title = "Difficluty";
	private int buttonWidth = 220;
        private GameBoard board;
        private final GuiButton EasyButton,MedButton,HardButton;
        public static long easy=10000,med=600000,hard=300000;
        public DifficultyPanel() {
		EasyButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, 220, buttonWidth, 60);
		EasyButton.addActionListener((ActionEvent e) -> {
                    GameBoard.setTime(easy);
                    GuiScreen.getInstance().setCurrentPanel("Play");
                });
                EasyButton.setText("Easy");
                add(EasyButton);
                MedButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, 310, buttonWidth, 60);
		MedButton.addActionListener((ActionEvent e) -> {
                    GameBoard.setTime(med);
                    GuiScreen.getInstance().setCurrentPanel("Play");
                });
		MedButton.setText("Medium");
		add(MedButton);
		HardButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, 400, buttonWidth, 60);
		HardButton.addActionListener((ActionEvent e) -> {
                    GameBoard.setTime(hard);
                    GuiScreen.getInstance().setCurrentPanel("Play");
                });
		HardButton.setText("Hard");
		add(HardButton);
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
	}
        
}
