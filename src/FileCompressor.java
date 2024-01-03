import java.io.*;

public class FileCompressor {
    private HuffmanCoder hc;
    public void encode(){
        StringBuilder input = new StringBuilder();
//        READ THE FILE
        try (BufferedReader br = new BufferedReader(new FileReader("src/huffmanCode/test.txt"))){
            int c;
            while ((c = br.read()) != -1) {
                input.append((char) c);
            }
//            System.out.println("Input:" + input);
            hc = new HuffmanCoder(input.toString());
            String output = hc.encode(input.toString());
            try (FileWriter fw = new FileWriter("src/huffmanCode/decoded-file.bin")) {
                fw.write(output);
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Compressed Successfully!!");
    }
    public void decode(){
        StringBuilder encodedMessage = new StringBuilder();
//        READ THE FILE
        try (FileInputStream fis = new FileInputStream(new File("src/huffmanCode/decoded-file.bin"))) {
            int singleByte;
            while ((singleByte = fis.read()) != -1) {
                encodedMessage.append((char) singleByte);
            }
            System.out.println(encodedMessage);
            String output = hc.decode(encodedMessage.toString());
            try (FileWriter fw = new FileWriter("src/huffmanCode/encoded-file.txt")) {
                fw.write(output);
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
