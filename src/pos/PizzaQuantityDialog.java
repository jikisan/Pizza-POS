package pos;

import javax.swing.*;
import java.awt.*;

public class PizzaQuantityDialog extends JDialog {
    private final JTextField quantityField;
    private int userQuantity;

    String[] pizzaMenu = {
            "HAWAIIAN MADNESS",
            "PEPPERONI SORPRESA",
            "CHICKEN HAWAIIAN",
            "BACON SAUSAGE BONANZA",
            "BARBECUE BEEF & MUSHROOM"
    };

    public PizzaQuantityDialog(Frame parent, int pizzaCode) {
        super(parent, "Enter Pizza Quantity", true);

        // Create a panel to hold the label and text field
        JPanel panel = new JPanel(new FlowLayout());
//        panel.setSize(500,500);
        panel.add(new JLabel("Enter Quantity:"));
        quantityField = new JTextField(10); // Set a preferred width
        panel.add(quantityField);

        // Add buttons
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> handleOkClick());
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose()); // Close the dialog

        // Add buttons to a separate panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(cancelButton);
        buttonPanel.add(okButton);

        // Add panels to the dialog
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().setSize(500,500);
        pack(); // Set the size based on content
        setLocationRelativeTo(parent); // Center the dialog relative to parent frame
    }

    private void handleOkClick() {
        try {
            // Parse the text field value to integer
            userQuantity = Integer.parseInt(quantityField.getText());
            dispose(); // Close the dialog on successful input
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getUserQuantity() {
        return userQuantity;
    }
}
