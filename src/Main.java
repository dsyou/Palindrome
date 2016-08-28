/**
 *  Palindrom e.g. aba
 *  c ->d
 *  d > c > b > a
 */
public class Main {


    public static boolean istPalindrom(char[] word) { //check if is Polidrome
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }

    private static boolean checkLastIsC(String k) {

        String t = k.substring(k.length() - 1);
        if (t.equals("c")) {
            return true;
        }

        return false;
    }

    private static String downgrade(String k) {

        String replace = null;
        if (k.endsWith("d")) {
            replace = k.replace("d", "c");
        }
        if (k.endsWith("c")) {
            replace = k.replace("c", "b");
        }
        if (k.endsWith("b")) {
            replace = k.replace("b", "a");
        }

        return replace;
    }

    public static void main(String args[]) throws Exception {


        for (int i = 0; i < args.length; i++) {
//            System.out.println("Length"+args.length);
            boolean flag = true;
            boolean flag_downGrade = false;
            int  t=0;
            if (istPalindrom(args[i].toCharArray())) {// is Polindrone
                t = 0;
            } else
                while (flag) {
                    //tutaj first condition
                    if (istPalindrom(args[i].toCharArray())) {// is Polindrone after transformation ?
                        flag=false;
                    } else {
                        if (checkLastIsC(args[i]) && !flag_downGrade) { // check the last is C
                            t++;
                            String k = args[i];
                            args[i] = k.replace(k.substring(k.length() - 1), "d");
                            istPalindrom(k.toCharArray());

                        } else { // downgrade letters
                            flag_downGrade = true;
                            t++;
                            String downgrade = downgrade((args[i]));
                            args[i] = downgrade(args[i]);
                            System.out.println(args[i]);
                        }

                    }

                }
            System.out.println("Transformation Steps:" + t);
        }


    } // End of Main
}


