
import ug.algo.trie.Trie;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Array;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Stream;
import java.util.ArrayList;

public class soccer {
    public static void main(String[] args) {
        int [] possible_goals = {1,2,3,4,5,6,7,8,9};
        String[]  checkwinning={"نجح", "نصر", "غلب", "فوق", "فاق", "فوز", "كسب", "هزم", "ربح", "نجح", "حصل",
                "حرز", "صدر", "جلب", "حوز", "حقق",  "أهل", "اهل", "برز", "بعد", "جوز", "عدا", "برع",
                "عبر", "خطا", "ميز", "غطى على", "فلح", "ظفر على", "نول", "قهر", "خضع", "خمد", "ذلل",
                "سلط", "سيطر", "وسيطر", "دمر", "خرب", "قضي", "حطم", "طور", "رقأ", "علا", "صعد", "رفع",
                "نزع", "سلب", "اخذ", "أخذ", "بهر", "فجأ", "دهش", "ذهل", "نقذ", "لقي", "برق", "لمع", "انتصرت", "فازت", "فاز",
                "ربحت", "حصل", "حصلت", "نال", "نالت", "انتصر", "هزمت", "فارت"
        };
        String[] done = new String [2];
        Scanner in = new Scanner(System.in);
        String[] countries = {"قطر","الاكوادور", "السينيغال","هولندا","بريطانيا", "ايران", "امريكا","استراليا", "كوريا", "اوروغواي","غانا","البرتغال",
        "الكاميرون", "سويسرا","صربيا", "البرازيل", "كرواتيا", "المغرب","كندا", "بلجيكا", "اليابان", "المانيا", "كوستاريكا", "اسبانيا",
        "تونس", "الدينمارك","فرنسا", "بولندا", "المكسيك","السعودية", "الارجنتين", "ويلز",};
        // This is a case sensitive trie
        Trie trie = new Trie(true, StandardCharsets.UTF_8);
        // Add words.
        trie.add("قطر");
        trie.add("الاكوادور");
        trie.add("السينيغال");
        trie.add("هولندا");
        trie.add("بريطانيا");
        trie.add("ايران");
        trie.add("امريكا");
        trie.add("ويلز");
        trie.add("الارجنتين");
        trie.add("السعودية");
        trie.add("المكسيك");
        trie.add("بولندا");
        trie.add("فرنسا");
        trie.add("الدينمارك");
        trie.add("تونس");
        trie.add("اسبانيا");
        trie.add("كوستاريكا");
        trie.add("المانيا");
        trie.add("اليابان");
        trie.add("بلجيكا");
        trie.add("كندا");
        trie.add("المغرب");
        trie.add("كرواتيا");
        trie.add("البرازيل");
        trie.add("صربيا");
        trie.add("سويسرا");
        trie.add("الكاميرون");
        trie.add("البرتغال");
        trie.add("غانا");
        trie.add("اوروغواي");
        trie.add("كوريا");
        trie.add("استراليا");
        // String Similarity using Levenshtein distance
        // Get words that are less than the given maximum distance from the target word
        System.out.println("ادخل الجملة المراد فحصها مع عدد الاجوال للدولتين");
        String temp = in.nextLine();
        temp = temp.replaceAll("إ", "ا");
        temp = temp.replaceAll("أ", "ا");
        temp = temp.replaceAll("آ", "ا");
        temp = temp.replaceAll("ؤ", "و");
        String []arr = temp.split("\\s+");
        //get score
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < temp.length(); i++) {
            if (Character.isDigit(temp.charAt(i))) {
                int number = Character.getNumericValue(temp.charAt(i));
                numbers.add(number);
            }
        }
        //check winning and losing
        int pointer=0;
        int flag=0;
        for(int i=0;i<checkwinning.length;i++){
            if(arr[0].equals(checkwinning[i])){
            flag++;
            }
        }
        if(flag>0){
            pointer=1;
        }else{
            pointer=-1;
        }
        //checking in inserted sentence
        String a = "";
        int check = 0;
            for (int i = 0; i < arr.length; i++) {
                    a="";
                    a=a+trie.getSimilarityMap(arr[i], 2);
                    a=a.replace("{", "");
                    a=a.replace("}", "");
                    a=a.replace("=", "");
                    a=a.replace("1", "");
                    a=a.replace("2", "");
                    a=a.replace("0", "");
                    for(int j=0; j<countries.length;j++) {
                        if (a.equals(countries[j])) {
                        done[check] = a;
                        check++;
                        }

                    }

        }
if (numbers.get(0)==numbers.get(1)){
    System.out.println("انتهت النتيجة بتعادل");
    System.out.println(done[0]+" "+ done[1]+" حازو على " + numbers.get(0));
}else{
        if(pointer ==1){
             System.out.println(done[0]+" "+ "فازت ب:" +" "+ numbers.get(0));
             System.out.println(done[1]+" "+ "خسرت ب:" +" "+ numbers.get(1));
}else
        if(pointer ==-1){
            System.out.println(done[1]+" "+ "فازت ب:" +" "+ numbers.get(1));
            System.out.println(done[0]+" "+ "خسرت ب:" +" "+ numbers.get(0));
        }else{
            System.out.println("invalid");
        }}
    }}