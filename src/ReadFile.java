

import java.io.*;

public class ReadFile {

    public void ReadFile(slist sll) throws IOException {
        // File file = new File("C:\Users\Youssef Badreldin\Desktop\contacts-data.txt;
        File file = new File("contacts.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            String[] Line = st.split(",");
            String firstname = Line[0];
            String lastname = Line[1];
            String email = Line[2];
            String homenumber = Line[3];
            String phonenumber = Line[4];
            String profession = Line[5];
            sll.add(firstname, lastname, email, homenumber, phonenumber, profession);
//                System.out.println(s1 + " " + s2);
        }
        br.close();
        return;
    }
}
