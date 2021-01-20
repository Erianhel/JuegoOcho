package cartasocho;

import javax.swing.*;

public class CartasOcho {

    public static void main(String[] args) {
        int gana1 = 0, pierde1 = 0, gana2 = 0, pierde2 = 0, apuesta, vpalo, vcarta, partidas = 0, tot1 = 0, tot2 = 0;
        String otraCarta, otraVez;
        String[] palo = {"bastos", "espada", "copa", "oro"};
        int[] cartas = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};

        do {

            JOptionPane.showMessageDialog(null, "Bienvenidos al Juego Cartas Ocho", "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                    new ImageIcon(CartasOcho.class.getResource("/img/cartas1.gif")));

            JOptionPane.showMessageDialog(null, "Instrucciones:\n**Primero deberá realizar su apuesta entre 50 - 500.\n**El objetivo del juego es obtener 8 puntos como máximo para ganar.\n**El usuario recibe su primer carta y tiene la posibilidad de pedir otra para acercarse al valor o bien, plantarse.\n**El valor de las cartas es su número, excepto las figuras (Sota, Caballo y Rey) que valen 1 punto.\n**El juego es al mejor de 5 partidas.\n**A jugar!!!!!", "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                    new ImageIcon(CartasOcho.class.getResource("/img/inicio2.gif")));

            while (partidas < 5) {
                //apuesta 50-300
                apuesta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su apuesta entre 50-500"));
                tot1 = 0;
                tot2 = 0;

                do {
                    //carta usuario
                    vpalo = (int) (Math.random() * 4);
                    vcarta = (int) (Math.random() * 10);
                    System.out.println("cartaUsuario: " + cartas[vcarta] + " de " + palo[vpalo]);

                    switch (cartas[vcarta]) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            tot1 = tot1 + cartas[vcarta];
                            System.out.println("tot1" + tot1);
                            JOptionPane.showMessageDialog(null, "Su carta es: " + cartas[vcarta] + " de " + palo[vpalo] + "\nLa suma de sus cartas: " + tot1, "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                                    new ImageIcon(CartasOcho.class.getResource("/img/carta-" + palo[vpalo] + "-" + cartas[vcarta] + ".png")));
                            break;
                        case 10:
                        case 11:
                        case 12:
                            tot1 = tot1 + 1;
                            JOptionPane.showMessageDialog(null, "Su carta es: " + cartas[vcarta] + " de " + palo[vpalo] + "\nLa suma de sus cartas: " + tot1, "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                                    new ImageIcon(CartasOcho.class.getResource("/img/carta-" + palo[vpalo] + "-" + cartas[vcarta] + ".png")));
                            break;
                    }

                    if (tot1 > 8) {
                        JOptionPane.showMessageDialog(null, "Te pasaste de 8!!!", "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                                new ImageIcon(CartasOcho.class.getResource("/img/perdiste.gif")));
                        apuesta = 0;
                        break;
                    }

                    otraCarta = JOptionPane.showInputDialog("Desea pedir otra carta? si/no");

                } while (otraCarta.equalsIgnoreCase("si"));

                //jugada máquina         
                while (tot2 < 7) {

                    vpalo = (int) (Math.random() * 4);
                    vcarta = (int) (Math.random() * 10);

                    System.out.println("cartaUsuario: " + cartas[vcarta] + " de " + palo[vpalo]);

                    switch (cartas[vcarta]) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            tot2 = tot2 + cartas[vcarta];
                            System.out.println("tot2" + tot2);
                            JOptionPane.showMessageDialog(null, "La jugada de la máquina es: " + cartas[vcarta] + " de " + palo[vpalo] + "\nLa suma de las cartas: " + tot2, "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                                    new ImageIcon(CartasOcho.class.getResource("/img/carta-" + palo[vpalo] + "-" + cartas[vcarta] + ".png")));
                            break;
                        case 10:
                        case 11:
                        case 12:
                            tot2 = tot2 + 1;
                            JOptionPane.showMessageDialog(null, "La jugada de la máquina es: " + cartas[vcarta] + " de " + palo[vpalo] + "\nLa suma de las cartas: " + tot2, "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                                    new ImageIcon(CartasOcho.class.getResource("/img/carta-" + palo[vpalo] + "-" + cartas[vcarta] + ".png")));
                            break;

                    }

                    if (tot2 > 8) {
                        JOptionPane.showMessageDialog(null, "La máquina se pasó de 8!!");
                    }

                }

                //condiciones 
                if (tot1 == 8 && tot2 < 8) {
                    JOptionPane.showMessageDialog(null, "Pleno 8!!!, Ganaste el triple de tu apuesta: " + apuesta*3, "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                            new ImageIcon(CartasOcho.class.getResource("/img/felicitaciones.gif")));
                    apuesta = apuesta * 3;
                    gana1++;
                    pierde2++;
                    partidas++;
                } else if (tot1 > 8 && tot2 > 8) {
                    JOptionPane.showMessageDialog(null, "Ha perdido esta ronda, ambos se pasaron de 8!!!!!!", "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                            new ImageIcon(CartasOcho.class.getResource("/img/pasado.gif")));
                    pierde1++;
                    pierde2++;
                    partidas++;
                } else if (tot1 > 8 && tot2 <= 8) {
                    JOptionPane.showMessageDialog(null, "Ha perdido esta ronda!!!!", "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                            new ImageIcon(CartasOcho.class.getResource("/img/pasado.gif")));
                    pierde1++;
                    gana2++;
                    partidas++;
                } else if (tot2 == 8 && tot1 < 8) {
                    JOptionPane.showMessageDialog(null, "Ha perdido esta ronda!!!!", "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                            new ImageIcon(CartasOcho.class.getResource("/img/pasado.gif")));
                    gana2++;
                    pierde1++;
                    partidas++;
                } else if (tot1 <= 8 && tot1 > tot2) {
                    JOptionPane.showMessageDialog(null, "Ha ganado esta ronda!!!, gana el doble de su apuesta: " + apuesta*2, "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                            new ImageIcon(CartasOcho.class.getResource("/img/felicitaciones.gif")));
                    apuesta = apuesta * 2;
                    gana1++;
                    pierde2++;
                    partidas++;
                } else if (tot2 <= 8 && tot2 > tot1) {
                    JOptionPane.showMessageDialog(null, "Ha perdido esta ronda!!!", "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                            new ImageIcon(CartasOcho.class.getResource("/img/pasado.gif")));
                    gana2++;
                    pierde1++;
                    partidas++;
                } else if (tot1 <= 8 && tot1 == tot2) {
                    JOptionPane.showMessageDialog(null, "Empate!!!!, se le devuelve la mitad de su apuesta: " + apuesta / 2);
                    partidas++;
                } else if (tot2 > 8 && tot1 <= 8) {
                    JOptionPane.showMessageDialog(null, "Ha ganado esta ronda!!!!, ha ganado el doble de su apuesta: " + apuesta*2, "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                            new ImageIcon(CartasOcho.class.getResource("/img/felicitaciones.gif")));
                    apuesta = apuesta * 2;
                    gana1++;
                    pierde2++;
                    partidas++;
                }
                System.out.println("partidas: " + partidas + " - gana1: " + gana1 + " - gana2: " + gana2);

                if (partidas == 5 && gana1 > gana2) {
                    JOptionPane.showMessageDialog(null, "Felicitaciones ha ganado!!!", "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                            new ImageIcon(CartasOcho.class.getResource("/img/ganador.gif")));
                } else if (partidas == 5 && gana2 > gana1) {
                    JOptionPane.showMessageDialog(null, "Lo sentimos ha perdido!!!", "Cartas Ocho", JOptionPane.PLAIN_MESSAGE,
                            new ImageIcon(CartasOcho.class.getResource("/img/gameover.gif")));
                }

            }

            otraVez = JOptionPane.showInputDialog("Quiere volver a jugar? si/no");

        } while (otraVez.equalsIgnoreCase("si"));

    } //fin main


} //fin clase
