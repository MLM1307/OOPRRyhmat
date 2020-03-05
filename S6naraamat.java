import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//Sisendfailiks on UTF-8 kodeeringus .txt fail, kus võõrkeelne sõna ja tema emakeelne vaste on eraldatud tab-iga.

public class S6naraamat {
    public static void main(String[] args) throws Exception {
        //küsime kasutajalt failinime ja kirjutame failis olevad sõnad listi, kus iga liige on
        //klassi Sõna isend.
        String sõnadeFail = JOptionPane.showInputDialog("Sisesta failinimi, kust soovid sõnu õppida");
        File fail = new File(sõnadeFail);
        if (fail.exists()) {
            ArrayList<S6na> s6nad = new ArrayList<>();
            try (Scanner sc = new Scanner(fail, "UTF-8")) {
                while (sc.hasNextLine()) {
                    String sõna = sc.nextLine();
                    String[] tükid = sõna.split("\t"); //Failis on saksakeelne sõna ja eestikeelne vaste eraldatud tab-iga
                    S6na s6na = new S6na(tükid[0], tükid[1]);
                    s6nad.add(s6na);
                }
            }
            //Loeme kokku, mitu sõna on sisestatud failis ja küsitakse kasutajalt, mitu sõna temalt küsida
            int sõnadeArv = Integer.parseInt(JOptionPane.showInputDialog("Sinu sisestatud failis on " + s6nad.size() +
                    " sõna. Mitu sõna tahad täna õppida"));

            //Valitakse juhuslikult sõnad, mida kasutajalt küsida (süsteem küsib sõnu niipalju kordi, kui kasutaja soovis
            if(s6nad.size()>sõnadeArv){
                int õigesti=0;
            for (int i = 0; i < sõnadeArv; i++) {
                int j = (int) (Math.random() * s6nad.size()); //valime indeksi, millist sõna küsida
                String kontroll = JOptionPane.showInputDialog(s6nad.get(j).getEmakeelneVaste());
                if (kontroll.equals(s6nad.get(j).getSõnaVõõrkeeles())) {
                    JOptionPane.showMessageDialog(null, "Vastasid õigesti: "+s6nad.get(j).getSõnaVõõrkeeles()+".");
                    õigesti++;
                } else {
                    JOptionPane.showMessageDialog(null, "Sinu vastus oli vale. Õige vastus on: "
                            + s6nad.get(j).getSõnaVõõrkeeles());
                }
            }
                JOptionPane.showMessageDialog(null, "Vastasid õigesti "+õigesti+" sõna.");
            }
            else{
                JOptionPane.showMessageDialog(null, "Failis ei ole nii palju sõnu!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sisestatud faili ei eksisteeri.");
        }
    }
}
