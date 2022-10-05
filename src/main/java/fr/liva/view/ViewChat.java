package fr.liva.view;

import fr.liva.components.buttons.LivaActionType;
import fr.liva.components.buttons.LivaButton;
import fr.liva.components.chat.LivaChatArea;
import fr.liva.components.chat.LivaChatBox;
import fr.liva.launcher.LauncherPanel;
import fr.liva.utils.LivaUtils;

public class ViewChat extends View {

    // Chat
    private LivaChatBox chatBox = new LivaChatBox();
    private LivaChatArea chatArea = new LivaChatArea();

    // Buttons
    private LivaButton sendButton;


    public ViewChat(LauncherPanel panel) {
        super(panel);
    }

    @Override
    public void init() {

        sendButton = new LivaButton(getPanel(), LivaUtils.getResource("buttons/button_toggled_false.png"));
        sendButton.setBounds(950, 670, 50, 50);
        sendButton.setAction(LivaActionType.HOVER, () -> {
            getPanel().setCursor(getPanel().getLauncher().hoverCursor());
        });

        // Add Components
        addComponent(chatBox, chatArea, sendButton);
    }
}
