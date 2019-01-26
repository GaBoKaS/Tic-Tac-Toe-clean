import java.awt.EventQueue;

public class Play extends ActionPerformers {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Play frame = new Play();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Play() {
		GenerateButtons();
		CreateActionPerformers();
	}
}
