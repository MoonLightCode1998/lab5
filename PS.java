import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PS {
    static BufferedImage image;
    static BufferedImage image2;
    public static int width;
    public static int height;

    public PS() {

    }


    public static void setImage(String path) {
        try {
            File input = new File(path);
            PS.image = ImageIO.read(input);
            width = PS.image.getWidth();
            height = image.getHeight();
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Wrong file path");
        }
    }

    public static void setImage2(String path) {
        try {
            File input = new File(path);
            PS.image2 = ImageIO.read(input);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Wrong file path");
        }
    }

    public void transformacjaLiniowaNegatyw() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();

                if (255 - red >= 0 && 255 - red <= 255) red = 255 - red;
                if (255 - green >= 0 && 255 - green <= 255) green = 255 - green;
                if (255 - blue >= 0 && 255 - blue <= 255) blue = 255 - blue;
                Color newColor = new Color(red, green, blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Wrong file path");
        }
    }

    public void transformacjaLiniowa(int b) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();

                red += b;
                green += b;
                blue += b;
                if (red > 255) red = 255;
                if (blue > 255) blue = 255;
                if (green > 255) green = 255;
                if (red < 0) red = 0;
                if (blue < 0) blue = 0;
                if (green < 0) green = 0;

                Color newColor = new Color(red, green, blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Wrong parameter");
        }
    }

    public void transformacjaPotegowa(double b) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                double red = c.getRed();
                double green = c.getGreen();
                double blue = c.getBlue();

                if (Math.pow(red / 255, b) >= 0 && Math.pow(red / 255, b) <= 255) red = Math.pow(red / 255, b) * 255;
                if (Math.pow(green / 255, b) >= 0 && Math.pow(green / 255, b) <= 255)
                    green = Math.pow(green / 255, b) * 255;
                if (Math.pow(blue / 255, b) >= 0 && Math.pow(blue / 255, b) <= 255)
                    blue = Math.pow(blue / 255, b) * 255;
                Color newColor = new Color((int) red, (int) green, (int) blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Wrong parameter");
        }
    }

    public void mieszanieSuma() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                int red2 = b.getRed();
                int green2 = b.getGreen();
                int blue2 = b.getBlue();

                red = red + red2;
                green = green + green2;
                blue = blue + blue2;
                if (red > 255) red = 255;
                if (blue > 255) blue = 255;
                if (green > 255) green = 255;
                if (red < 0) red = 0;
                if (blue < 0) blue = 0;
                if (green < 0) green = 0;
                Color newColor = new Color(red, green, blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }

    public void mieszanieOdejmowanie() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                double red = c.getRed();
                double green = c.getGreen();
                double blue = c.getBlue();
                double red2 = b.getRed();
                double green2 = b.getGreen();
                double blue2 = b.getBlue();
                red = ((red / 255) + (red2 / 255) - 1) * 255;
                green = ((green / 255) + (green2 / 255) - 1) * 255;
                blue = ((blue / 255) + (blue2 / 255) - 1) * 255;

                if (red > 255) red = 255;
                if (blue > 255) blue = 255;
                if (green > 255) green = 255;
                if (red < 0) red = 0;
                if (blue < 0) blue = 0;
                if (green < 0) green = 0;
                Color newColor = new Color((int) red, (int) green, (int) blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }

    public void mieszanieRoznica() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                int red2 = b.getRed();
                int green2 = b.getGreen();
                int blue2 = b.getBlue();
                if (red - red2 < 0) red = (red - red2) * -1;
                else red = red - red2;
                if (green - green2 < 0) green = (green - green2) * -1;
                else green = green - green2;
                if (blue - blue2 < 0) blue = (blue - blue2) * -1;
                else blue = blue - blue2;
                Color newColor = new Color(red, green, blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }

    public void mieszanieMnozenie() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                double red = c.getRed();
                double green = c.getGreen();
                double blue = c.getBlue();
                double red2 = b.getRed();
                double green2 = b.getGreen();
                double blue2 = b.getBlue();


                red = ((red / 255) * (red2 / 255)) * 255;
                green = ((green / 255) * (green2 / 255)) * 255;
                blue = ((blue / 255) * (blue2 / 255)) * 255;

                if (red > 255) red = 255;
                if (blue > 255) blue = 255;
                if (green > 255) green = 255;
                if (red < 0) red = red * -1;
                if (blue < 0) blue = green * -1;
                if (green < 0) green = blue * -1;
                Color newColor = new Color((int) red, (int) green, (int) blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }

    public void mieszanieMnozenieOdwrtonosci() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                double red = c.getRed();
                double green = c.getGreen();
                double blue = c.getBlue();
                double red2 = b.getRed();
                double green2 = b.getGreen();
                double blue2 = b.getBlue();

                red = (1 - (1 - (red / 255) * (1 - (red2 / 255)))) * 255;
                green = (1 - (1 - (green / 255) * (1 - (green2 / 255)))) * 255;
                blue = (1 - (1 - (blue / 255) * (1 - (blue2 / 255)))) * 255;
                if (red > 255) red = 255;
                if (blue > 255) blue = 255;
                if (green > 255) green = 255;
                if (red < 0) red = 0;
                if (blue < 0) blue = 0;
                if (green < 0) green = 0;

                Color newColor = new Color((int) red, (int) green, (int) blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }

    public void mieszanieCiemniejsze() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                int red2 = b.getRed();
                int green2 = b.getGreen();
                int blue2 = b.getBlue();

                if (red > red2) red = red2;
                if (green > green2) green = green2;
                if (blue > blue2) blue = blue2;
                Color newColor = new Color(red, green, blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }

    public void mieszanieJasniejsze() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                int red2 = b.getRed();
                int green2 = b.getGreen();
                int blue2 = b.getBlue();

                if (red < red2) red = red2;
                if (green < green2) green = green2;
                if (blue < blue2) blue = blue2;
                Color newColor = new Color(red, green, blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }

    public void mieszanieWylaczenie() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                double red = c.getRed();
                double green = c.getGreen();
                double blue = c.getBlue();
                double red2 = b.getRed();
                double green2 = b.getGreen();
                double blue2 = b.getBlue();
                if (((red / 255) + (red2 / 255) - 2 * (red / 255) * (red2 / 255)) * 255 >= 0 && ((red / 255) + (red2 / 255) - 2 * (red / 255) * (red2 / 255)) * 255 <= 255)
                    red = ((red / 255) + (red2 / 255) - 2 * (red / 255) * (red2 / 255)) * 255;
                if (((green / 255) + (green2 / 255) - 2 * (green / 255) * (green2 / 255)) * 255 >= 0 && ((green / 255) + (green2 / 255) - 2 * (green / 255) * (green2 / 255)) * 255 <= 255)
                    green = ((green / 255) + (green2 / 255) - 2 * (green / 255) * (green2 / 255)) * 255;
                if (((blue / 255) + (blue2 / 255) - 2 * (blue / 255) * (blue2 / 255)) * 255 >= 0 && ((blue / 255) + (blue2 / 255) - 2 * (blue / 255) * (blue2 / 255)) * 255 <= 255)
                    blue = ((blue / 255) + (blue2 / 255) - 2 * (blue / 255) * (blue2 / 255)) * 255;
                Color newColor = new Color((int) red, (int) green, (int) blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }

    public void mieszanieNakladka() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                double red = c.getRed();
                double green = c.getGreen();
                double blue = c.getBlue();
                double red2 = b.getRed();
                double green2 = b.getGreen();
                double blue2 = b.getBlue();

                if (red / 255 < 0.5) red = (2 * (red / 255) * (red2 / 255)) * 255;
                else
                    red = (1 - (2 * (1 - (red / 255)) * (1 - red2 / 255))) * 255;
                if (green / 255 < 0.5) green = (2 * (green / 255) * (green2 / 255)) * 255;
                else
                    green = (1 - (2 * (1 - (green / 255)) * (1 - green2 / 255))) * 255;
                if (blue / 255 < 0.5) blue = (2 * (blue / 255) * (blue2 / 255)) * 255;
                else
                    blue = (1 - (2 * (1 - (blue / 255)) * (1 - blue2 / 255))) * 255;
                Color newColor = new Color((int) red, (int) green, (int) blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }

    public void mieszanieOstreSwiatlo() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                double red = c.getRed();
                double green = c.getGreen();
                double blue = c.getBlue();
                double red2 = b.getRed();
                double green2 = b.getGreen();
                double blue2 = b.getBlue();

                if (red2 / 255 < 0.5) red = (2 * (red / 255) * (red2 / 255)) * 255;
                else
                    red = (1 - (2 * (1 - (red / 255)) * (1 - red2 / 255))) * 255;
                if (green2 / 255 < 0.5) green = (2 * (green / 255) * (green2 / 255)) * 255;
                else
                    green = (1 - (2 * (1 - (green / 255)) * (1 - green2 / 255))) * 255;
                if (blue2 / 255 < 0.5) blue = (2 * (blue / 255) * (blue2 / 255)) * 255;
                else
                    blue = (1 - (2 * (1 - (blue / 255)) * (1 - blue2 / 255))) * 255;
                Color newColor = new Color((int) red, (int) green, (int) blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }

    public void mieszanieLagodneSwiatlo() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                double red = (c.getRed());
                double green = (c.getGreen());
                double blue = (c.getBlue());
                double red2 = (b.getRed());
                double green2 = (b.getGreen());
                double blue2 = (b.getBlue());

                if (red2 / 255 < 0.5)
                    red = (2 * (red / 255) * (red2 / 255) + Math.pow((red / 255), 2) * (1 - 2 * (red2 / 255))) * 255;
                else
                    red = (Math.sqrt(red / 255) * (2 * (red2 / 255) - 1) + 2 * (red / 255) * (1 - (red2 / 255))) * 255;
                if (green2 / 255 < 0.5)
                    green = (2 * (green / 255) * (green2 / 255) + Math.pow((green / 255), 2) * (1 - 2 * (green2 / 255))) * 255;
                else
                    green = (Math.sqrt(green / 255) * (2 * (green2 / 255) - 1) + 2 * (green / 255) * (1 - (green2 / 255))) * 255;
                if (blue2 / 255 < 0.5)
                    blue = (2 * (blue / 255) * (blue2 / 255) + Math.pow((blue / 255), 2) * (1 - 2 * (blue2 / 255))) * 255;
                else
                    blue = (Math.sqrt(blue / 255) * (2 * (blue2 / 255) - 1) + 2 * (blue / 255) * (1 - (blue2 / 255))) * 255;
                Color newColor = new Color((int) red, (int) green, (int) blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }

    public void mieszanieRozceinczenie() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                double red = c.getRed();
                double green = c.getGreen();
                double blue = c.getBlue();
                double red2 = b.getRed();
                double green2 = b.getGreen();
                double blue2 = b.getBlue();

                red = ((red / 255) / (1 - (red2 / 255))) * 255;
                green = ((green / 255) / (1 - (green2 / 255))) * 255;
                blue = ((blue / 255) / (1 - (blue2 / 255))) * 255;

                if (red > 255) red = 255;
                if (blue > 255) blue = 255;
                if (green > 255) green = 255;
                if (red < 0) red = 0;
                if (blue < 0) blue = 0;
                if (green < 0) green = 0;
                Color newColor = new Color((int) red, (int) green, (int) blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }

    public void mieszanieWypalenie() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                double red = c.getRed();
                double green = c.getGreen();
                double blue = c.getBlue();
                double red2 = b.getRed();
                double green2 = b.getGreen();
                double blue2 = b.getBlue();

                red = (1 - (1 - (red / 255)) / (red2 / 255)) * 255;
                green = (1 - (1 - (green / 255)) / (green2 / 255)) * 255;
                blue = (1 - (1 - (blue / 255)) / (blue2 / 255)) * 255;
                if (red > 255) red = 255;
                if (blue > 255) blue = 255;
                if (green > 255) green = 255;
                if (red < 0) red = 0;
                if (blue < 0) blue = 0;
                if (green < 0) green = 0;
                Color newColor = new Color((int) red, (int) green, (int) blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }

    public void mieszanieReflectMode() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                double red = c.getRed();
                double green = c.getGreen();
                double blue = c.getBlue();
                double red2 = b.getRed();
                double green2 = b.getGreen();
                double blue2 = b.getBlue();

                /*if ((Math.pow((red / 255), 2) / (1 - (red2 / 255))) * 255 >= 0 && (Math.pow((red / 255), 2) / (1 - (red2 / 255))) * 255 <= 255)
                    red = (Math.pow((red / 255), 2) / (1 - (red2 / 255))) * 255;
                else red=255;
                if ((Math.pow((green / 255), 2) / (1 - (green2 / 255))) * 255 >= 0 && (Math.pow((green / 255), 2) / (1 - (green2 / 255))) * 255 <= 255)
                    green = (Math.pow((green / 255), 2) / (1 - (green2 / 255))) * 255;
                else green=255;
                if ((Math.pow((blue / 255), 2) / (1 - (blue2 / 255))) * 255 >= 0 && (Math.pow((blue / 255), 2) / (1 - (blue2 / 255))) * 255 <= 255)
                    blue = (Math.pow((blue / 255), 2) / (1 - (blue2 / 255))) * 255;
                else blue =255;*/
                red = (Math.pow((red / 255), 2) / (1 - (red2 / 255))) * 255;
                green = (Math.pow((green / 255), 2) / (1 - (green2 / 255))) * 255;
                blue = (Math.pow((blue / 255), 2) / (1 - (blue2 / 255))) * 255;
                if (red > 255) red = 255;
                if (blue > 255) blue = 255;
                if (green > 255) green = 255;
                if (red < 0) red = 0;
                if (blue < 0) blue = 0;
                if (green < 0) green = 0;
                Color newColor = new Color((int) red, (int) green, (int) blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }

    public void mieszaniePrzezroczystosc(double alfa) {
        for (int x = 0; x < PS.width; x++) {
            for (int y = 0; y < PS.height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                double red = c.getRed();
                double green = c.getGreen();
                double blue = c.getBlue();
                double red2 = b.getRed();
                double green2 = b.getGreen();
                double blue2 = b.getBlue();

                if ((1 - alfa) * red2 + alfa * red >= 0 && (1 - alfa) * red2 + alfa * red <= 255)
                    red = (1 - alfa) * red2 + alfa * red;
                if ((1 - alfa) * green2 + alfa * green >= 0 && (1 - alfa) * green2 + alfa * green <= 255)
                    green = (1 - alfa) * green2 + alfa * green;
                if ((1 - alfa) * blue2 + alfa * blue >= 0 && (1 - alfa) * blue2 + alfa * blue <= 255)
                    blue = (1 - alfa) * blue2 + alfa * blue;
                Color newColor = new Color((int) red, (int) green, (int) blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }

    public void mieszanieNegacja() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(image.getRGB(x, y));
                Color b = new Color(image2.getRGB(x, y));
                double red = c.getRed();
                double green = c.getGreen();
                double blue = c.getBlue();
                double red2 = b.getRed();
                double green2 = b.getGreen();
                double blue2 = b.getBlue();

                if (1 - (red / 255) - (red2 / 255) < 0) red = (1 - (1 - (red / 255) - (red2 / 255)) * -1) * 255;
                else
                    red = (1 - (1 - (red / 255) - (red2 / 255))) * 255;
                if (1 - (green / 255) - (green2 / 255) < 0)
                    green = (1 - (1 - (green / 255) - (green2 / 255)) * -1) * 255;
                else
                    green = (1 - (1 - (green / 255) - (green2 / 255))) * 255;
                if (1 - (blue / 255) - (blue2 / 255) < 0) blue = (1 - (1 - (blue / 255) - (blue2 / 255)) * -1) * 255;
                else
                    blue = (1 - (1 - (blue / 255) - (blue2 / 255))) * 255;

                Color newColor = new Color((int) red, (int) green, (int) blue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        try {
            File ouptut = new File("grayscale.png");
            ImageIO.write(image, "png", ouptut);
        } catch (Exception e) {
            FrameGui.errorLabel.setText("Needed two images");
        }
    }
}
