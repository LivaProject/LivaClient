package fr.liva.view;

import fr.liva.Main;
import fr.liva.components.buttons.LivaActionType;
import fr.liva.components.buttons.LivaButton;
import fr.liva.components.chat.LivaChatField;
import fr.liva.components.chat.LivaChatBox;
import fr.liva.launcher.LauncherPanel;
import fr.liva.utils.LivaUtils;
import lombok.Getter;

@Getter
public class ViewChat extends View {

    // Chat
    private LivaChatBox chatBox = new LivaChatBox();
    private LivaChatField chatField = new LivaChatField();

    // Buttons
    private LivaButton sendButton;

    public ViewChat(LauncherPanel panel) {
        super(panel);
    }

    @Override
    public void init() {

        sendButton = new LivaButton(getPanel(), LivaUtils.getResource("buttons/button_toggled_false.png"));
        sendButton.setBounds(950, 670, 50, 50);
        sendButton.setAction(LivaActionType.PRESS, () -> {
            Main.livaClient.sendMessage("Chat " + Main.livaClient.getName() + " " + chatField.getText());
            chatField.setText("");
        });

        // Add Components
        addComponent(chatBox, chatField, sendButton);
    }
}
