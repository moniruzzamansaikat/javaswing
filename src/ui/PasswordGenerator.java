package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ItemEvent;
import java.util.Random;

public class PasswordGenerator extends BaseWindow {
    private static final long serialVersionUID = -6363243873929009524L;
    private JTextField textField;
    private boolean hasNumber      = true;
    private boolean hasSpecialChar = false;

    public PasswordGenerator() {
        super("Generate Password");
        setLayout(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill  = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        setIconImage(new ImageIcon("src/assets/icon.jpg").getImage());

        addComponents(gbc);
        setVisible(true);
    }

    protected void addComponents(GridBagConstraints gbc) {
        gbc.gridy++;
        JLabel headerLabel = new JLabel("Saikat's App");

        headerLabel.setFont(new Font("Arial", Font.BOLD, 24)); 
        headerLabel.setForeground(Color.BLUE);
        add(headerLabel);
        
        // Number Checkbox
        JCheckBox hasNumberCheckBox = new JCheckBox("Include Numbers", true);
        hasNumberCheckBox.addItemListener(e -> hasNumber = e.getStateChange() == ItemEvent.SELECTED);
        add(hasNumberCheckBox, gbc);

        // Special Character Checkbox
        gbc.gridy++;
        JCheckBox hasSpecialCharCheckBox = new JCheckBox("Include Special Characters");
        hasSpecialCharCheckBox.addItemListener(e -> hasSpecialChar = e.getStateChange() == ItemEvent.SELECTED);
        add(hasSpecialCharCheckBox, gbc);

        // Line Break (Empty Space)
        gbc.gridy++;
        gbc.gridwidth = 2; // Make the next row elements span two columns
        add(new JLabel(" "), gbc);

        // Label
        gbc.gridy++;
        gbc.gridwidth = 1; 
        add(new JLabel("Generated Password:"), gbc);

        gbc.gridx = 1;
        textField = new JTextField(20);
        textField.setEditable(false);
        add(textField, gbc);

        // Generate Button
        gbc.gridy++;
        gbc.gridx = 0;
        JButton generateButton = new JButton("Generate");
        generateButton.addActionListener(e -> textField.setText(generatePassword(12)));
        add(generateButton, gbc);

        // Copy Button
        gbc.gridx = 1;
        JButton copyButton = new JButton("Copy");
        copyButton.addActionListener(e -> {
            copyToClipboard(textField.getText());
            copyButton.setText("Copied");

            Timer timer = new Timer(2000, event -> {
                copyButton.setText("Copy");
            });
            timer.setRepeats(false); // Only execute once
            timer.start(); // Start the timer
        });
        
        add(copyButton, gbc);
    }

    private String generatePassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        if (hasNumber) chars += "0123456789";
        if (hasSpecialChar) chars += "!@#$%^&*";

        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }

        return password.toString();
    }

    private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    }

	@Override
	protected void addComponents() {
		// TODO Auto-generated method stub
		
	}
}
