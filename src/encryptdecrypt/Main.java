
package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String command = "enc";
        String sentence = "";
        int n = 0;
        int alg = 0;
        String input = "";
        String output = "";
        String ahah = "unicode";
        for (int i = 0; i < args.length; i++) {
            if (args[i] == "-mode") {
                command = args[i + 1];
            } else if (args[i] == "-key") {
                n = Integer.parseInt(args[i + 1]);
            } else if (args[i] == "-data") {
                sentence = args[i + 1];
            } else if (args[i].equals("-in")) {
                input = (args[i + 1]);
                alg = 1;
            } else if (args[i].equals("-out")) {
                output = args[i + 1];
            } else if (args[i].equals("-alg")) {
                ahah = args[i+1];
            }
        }
        if (sentence != "" && output != "") {
            alg = 2;
        }
        StringBuilder abc = new StringBuilder(sentence);
        switch (alg) {
            case 1:
                File in = new File(input);
                File out = new File(output);
                Scanner sc = new Scanner(in);
                FileWriter printWriter = new FileWriter(out);
                while (sc.hasNext()) {
                    String word = sc.nextLine();
                    StringBuilder abz = new StringBuilder(word);
                    switch (command) {
                        case "enc":
                            if (ahah.equals("unicode")) {
                                for (int i = 0; i < abz.length(); i++) {
                                    abz.replace(i, i + 1, String.valueOf((char) (abz.charAt(i) + n)));
                                }
                                break;} else {
                                for (int i = 0; i < abz.length(); i++) {
                                    if ((int) abz.charAt(i) > 65 && (int) abz.charAt(i) < 90) {
                                        if ((int) (abz.charAt(i) + n) < 90) {
                                            abz.replace(i, i + 1, String.valueOf((char) (abz.charAt(i) + n)));
                                        } else {
                                            abz.replace(i, i + 1, String.valueOf((char) (64 + (abz.charAt(i) + n) - 90)));
                                        }
                                    } else if ((int) abz.charAt(i) > 97 && (int) abz.charAt(i) < 122) {
                                        if ((int) (abz.charAt(i) + n) < 122) {
                                            abz.replace(i, i + 1, String.valueOf((char) (abz.charAt(i) + n)));
                                        } else {
                                            abz.replace(i, i + 1, String.valueOf((char) (96 + (abz.charAt(i) + n) - 122)));
                                        }
                                    }

                                }
                                break;
                            }
                        default:
                            if (ahah.equals("unicode")) {
                                for (int i = 0; i < abz.length(); i++) {
                                    abz.replace(i, i + 1, String.valueOf((char) (abz.charAt(i) - n)));
                                }
                                break;} else {
                                for (int i = 0; i < abz.length(); i++) {
                                    if ((int) abz.charAt(i) > 65 && (int) abz.charAt(i) < 90) {
                                        if ((int) (abz.charAt(i) - n) > 64) {
                                            abz.replace(i, i + 1, String.valueOf((char) (abz.charAt(i) - n)));
                                        } else {
                                            abz.replace(i, i + 1, String.valueOf((char) (91 - ( 65 - (abz.charAt(i) - n)))));
                                        }
                                    } else if ((int) abz.charAt(i) > 97 && (int) abz.charAt(i) < 122) {
                                        if ((int) (abz.charAt(i) - n) > 96) {
                                            abz.replace(i, i + 1, String.valueOf((char) (abz.charAt(i) - n)));
                                        } else {
                                            abz.replace(i, i + 1, String.valueOf((char) (123 - (97 - (abz.charAt(i) - n)))));
                                        }
                                    }

                                }
                                break;
                            }
                    }
                    printWriter.write(String.valueOf(abz));
                }
                sc.close();
                printWriter.close();
                break;
            case 2:
                File out1 = new File(output);
                FileWriter printWriter1 = new FileWriter(out1);
                switch (command) {
                    case "enc":
                        if  (ahah.equals("unicode")) {
                            for (int i = 0; i < abc.length(); i++) {
                                abc.replace(i, i + 1, String.valueOf((char) (abc.charAt(i) + n)));
                            }
                            break;} else {
                            for (int i = 0; i < abc.length(); i++) {
                                if ((int) abc.charAt(i) > 65 && (int) abc.charAt(i) < 90) {
                                    if ((int) (abc.charAt(i) + n) < 90) {
                                        abc.replace(i, i + 1, String.valueOf((char) (abc.charAt(i) + n)));
                                    } else {
                                        abc.replace(i, i + 1, String.valueOf((char) (64 + (abc.charAt(i) + n) - 90)));
                                    }
                                } else if ((int) abc.charAt(i) > 97 && (int) abc.charAt(i) < 122) {
                                    if ((int) (abc.charAt(i) + n) < 122) {
                                        abc.replace(i, i + 1, String.valueOf((char) (abc.charAt(i) + n)));
                                    } else {
                                        abc.replace(i, i + 1, String.valueOf((char) (96 + (abc.charAt(i) + n) - 122)));
                                    }
                                }

                            }
                        }
                    default:
                        if (ahah.equals("unicode")) {
                            for (int i = 0; i < abc.length(); i++) {
                                abc.replace(i, i + 1, String.valueOf((char) (abc.charAt(i) - n)));
                            }
                            break;} else {
                            for (int i = 0; i < abc.length(); i++) {
                                if ((int) abc.charAt(i) > 65 && (int) abc.charAt(i) < 90) {
                                    if ((int) (abc.charAt(i) - n) > 64) {
                                        abc.replace(i, i + 1, String.valueOf((char) (abc.charAt(i) - n)));
                                    } else {
                                        abc.replace(i, i + 1, String.valueOf((char) (91 - ( 65 - (abc.charAt(i) - n)))));
                                    }
                                } else if ((int) abc.charAt(i) > 97 && (int) abc.charAt(i) < 122) {
                                    if ((int) (abc.charAt(i) - n) > 96) {
                                        abc.replace(i, i + 1, String.valueOf((char) (abc.charAt(i) - n)));
                                    } else {
                                        abc.replace(i, i + 1, String.valueOf((char) (123 - (97 - (abc.charAt(i) - n)))));
                                    }
                                }

                            }
                        }
                }
                printWriter1.write(String.valueOf(abc));

                break;
            case 0:
                switch (command) {
                    case "enc":
                        if (ahah.equals("unicode")) {
                            for (int i = 0; i < abc.length(); i++) {
                                abc.replace(i, i + 1, String.valueOf((char) (abc.charAt(i) + n)));
                            }
                            break;} else {
                            for (int i = 0; i < abc.length(); i++) {
                                if ((int) abc.charAt(i) > 65 && (int) abc.charAt(i) < 90) {
                                    if ((int) (abc.charAt(i) + n) < 90) {
                                        abc.replace(i, i + 1, String.valueOf((char) (abc.charAt(i) + n)));
                                    } else {
                                        abc.replace(i, i + 1, String.valueOf((char) (64 + (abc.charAt(i) + n) - 90)));
                                    }
                                } else if ((int) abc.charAt(i) > 97 && (int) abc.charAt(i) < 122) {
                                    if ((int) (abc.charAt(i) + n) < 122) {
                                        abc.replace(i, i + 1, String.valueOf((char) (abc.charAt(i) + n)));
                                    } else {
                                        abc.replace(i, i + 1, String.valueOf((char) (96 + (abc.charAt(i) + n) - 122)));
                                    }
                                }

                            }
                        }
                    default:
                        if (ahah.equals("unicode")) {
                            for (int i = 0; i < abc.length(); i++) {
                                abc.replace(i, i + 1, String.valueOf((char) (abc.charAt(i) - n)));
                            }
                            break;} else {
                            for (int i = 0; i < abc.length(); i++) {
                                if ((int) abc.charAt(i) > 65 && (int) abc.charAt(i) < 90) {
                                    if ((int) (abc.charAt(i) - n) > 64) {
                                        abc.replace(i, i + 1, String.valueOf((char) (abc.charAt(i) - n)));
                                    } else {
                                        abc.replace(i, i + 1, String.valueOf((char) (91 - ( 65 - (abc.charAt(i) - n)))));
                                    }
                                } else if ((int) abc.charAt(i) > 97 && (int) abc.charAt(i) < 122) {
                                    if ((int) (abc.charAt(i) - n) > 96) {
                                        abc.replace(i, i + 1, String.valueOf((char) (abc.charAt(i) - n)));
                                    } else {
                                        abc.replace(i, i + 1, String.valueOf((char) (123 - (97 - (abc.charAt(i) - n)))));
                                    }
                                }

                            }
                        }
                }
                System.out.println(abc);
        }


    }
}
