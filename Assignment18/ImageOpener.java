import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageOpener extends JFrame {
    private JLabel imageLabel;
    private BufferedImage originalImage;
    private BufferedImage displayedImage;
    private double scale = 1.0;
    private int rotation = 0;

    public ImageOpener() {
        setTitle("Image Opener");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize the label where the image will be displayed
        imageLabel = new JLabel("", JLabel.CENTER);
        add(new JScrollPane(imageLabel), BorderLayout.CENTER);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a file menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Create menu items
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        // Add action listeners to menu items
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openImage();
            }
        });

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add menu items to the file menu
        fileMenu.add(openMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // Add the menu bar to the frame
        setJMenuBar(menuBar);

        // Create a toolbar
        JToolBar toolBar = new JToolBar();
        add(toolBar, BorderLayout.NORTH);

        // Add buttons to the toolbar
        JButton zoomInButton = new JButton("Zoom In");
        JButton zoomOutButton = new JButton("Zoom Out");
        JButton rotateButton = new JButton("Rotate");
        JButton resetButton = new JButton("Reset");

        toolBar.add(zoomInButton);
        toolBar.add(zoomOutButton);
        toolBar.add(rotateButton);
        toolBar.add(resetButton);

        // Add action listeners to toolbar buttons
        zoomInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scale *= 1.2;
                updateImage();
            }
        });

        zoomOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scale /= 1.2;
                updateImage();
            }
        });

        rotateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotation = (rotation + 90) % 360;
                updateImage();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scale = 1.0;
                rotation = 0;
                updateImage();
            }
        });
    }

    private void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                originalImage = ImageIO.read(selectedFile);
                if (originalImage != null) {
                    scale = 1.0;
                    rotation = 0;
                    updateImage();
                    setTitle(selectedFile.getName());
                } else {
                    JOptionPane.showMessageDialog(this, "The selected file is not a valid image.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error opening image: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateImage() {
        if (originalImage == null) {
            return;
        }

        int newWidth = (int) (originalImage.getWidth() * scale);
        int newHeight = (int) (originalImage.getHeight() * scale);

        Image tempImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.drawImage(tempImage, 0, 0, null);
        g2d.dispose();

        displayedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        g2d = displayedImage.createGraphics();
        g2d.rotate(Math.toRadians(rotation), newWidth / 2.0, newHeight / 2.0);
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();

        imageLabel.setIcon(new ImageIcon(displayedImage));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageOpener frame = new ImageOpener();
            frame.setVisible(true);
        });
    }
}
