package fr.liva.view;

import fr.liva.Main;
import fr.liva.ViewType;
import fr.liva.components.buttons.LivaActionType;
import fr.liva.components.buttons.LivaButton;
import fr.liva.components.chat.LivaChatField;
import fr.liva.components.chat.LivaChatBox;
import fr.liva.launcher.LauncherPanel;
import fr.liva.utils.LivaUtils;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ScrollPaneUI;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import javax.swing.text.DefaultCaret;
import java.awt.*;

@Getter
public class ViewChat extends View {

    // Chat
    private LivaChatBox chatBox = new LivaChatBox();
    private JScrollPane scrollPane;
    private LivaChatField chatField = new LivaChatField();

    // Buttons
    private LivaButton sendButton;

    public ViewChat(LauncherPanel panel) {
        super(panel, ViewType.RIGHT_BOX);
    }

    @Override
    public void init() {

        scrollPane = new JScrollPane(chatBox);
        scrollPane.setBounds(740, 220, 270, 445);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
        scrollPane.setViewportBorder(null);
        DefaultCaret caret = (DefaultCaret) chatBox.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        sendButton = new LivaButton(getPanel(), LivaUtils.getResource("buttons/button_toggled_false.png"));
        sendButton.setBounds(980, 680, 30, 30);
        sendButton.setAction(LivaActionType.PRESS, () -> {
            Main.livaClient.sendMessage("Chat " + Main.livaClient.getName() + " " + chatField.getText());
            chatField.setText("");
        });

        // Add Components
        addComponent(scrollPane, chatField, sendButton);
    }
}
