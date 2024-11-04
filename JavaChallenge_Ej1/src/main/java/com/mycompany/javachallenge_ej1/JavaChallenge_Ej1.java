package com.mycompany.javachallenge_ej1;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JavaChallenge_Ej1 {
    
    private static List<CardHolder> cardHoldersList = new ArrayList<>();
    private static List<CreditCard> cardsList = new ArrayList<>();
    
    public static void main(String[] args) throws ParseException {
        int opc;
        CardHolder defaultHolder = new CardHolder(150,"Alejandro","Di Stefano","125",LocalDate.now(),"ale@gmail.com");
        cardHoldersList.add(defaultHolder);
        do {
            opc = Menu();
            switch (opc) {
                case 1:
                    createCardHolder();
                    break;
                case 2:
                    createCreditCard();
                    break;
                case 3:
                    cardHolderCards();
                    break;
                case 4:
                    RateConsult();
                    break;
                default:
                    break;
                 
            }
        } while (opc != 5);

    }

    public static int Menu() {

        Scanner keyboard = new Scanner(System.in);
        int input = 10; //Lo inicializo en un valor erroneo para que entre al bucle

        do {
            System.out.println("Bienvenidos al Ejercicio 1, seleccione la opcion que desee operar");
            System.out.println("1 - Registrar persona");
            System.out.println("2 - Registrar tarjeta");
            System.out.println("3 - Consultar información");
            System.out.println("4 - Consultar tasa de marcas por fecha");
            System.out.println("5 - Salir");

            try {
                input = keyboard.nextInt();
                if (input < 1 || input > 5) {
                    System.out.println("Opcion invalida. Por favor, ingrese un numero entre 1 y 5.");
                }
            } catch (InputMismatchException e) {

                System.out.println("Opcion invalida. Por favor, ingrese un numero entre 1 y 5.");
                keyboard.next();
            }
        } while (input < 1 || input > 5);

        return input;
    }
    
    public static void createCardHolder() throws ParseException{
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Ingrese el nombre:");
        String name = keyboard.nextLine();

        System.out.print("Ingrese el apellido:");
        String lastName = keyboard.nextLine();

        System.out.print("Ingrese el DNI:");
        String dni = validDni();
        
        
        System.out.print("Ingrese la fecha de nacimiento (dd/mm/yyyy):");
        String birthDate = ValidDate();
        
        System.out.print("Ingrese el email:");
        String email;
        while (true) {
            email = keyboard.nextLine();
            if (email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                break;
            } else {
                System.out.println("Email inválido.");
                System.out.print("Ingrese un email válido:");
            }
        }
        int Id = GetRandom();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birth = LocalDate.parse(birthDate, formatter);
        CardHolder newHolder = new CardHolder(Id,name,lastName,dni,birth,email);
        cardHoldersList.add(newHolder);
        System.out.println("Registro completado: "+  newHolder.getId() + " - " + newHolder.getName() + " " + newHolder.getLastName() + ", DNI: " + newHolder.getDni() + ", Fecha de nacimiento: " + newHolder.getFormattedBirthDate() + ", Email: " + newHolder.getEmail());
    }
    
    public static void createCreditCard(){
        Scanner keyboard = new Scanner(System.in);
       int input = 10;
        
        do { 
            System.out.println("Ingrese que tipo de tarjeta desea registrar:");
            System.out.println("1 - VISA");
            System.out.println("2 - NARA");
            System.out.println("3 - AMEX");
            
            try {
                input = keyboard.nextInt();
                if (input < 1 || input > 3) {
                    System.out.println("Opcion invalida. Por favor, ingrese un numero entre 1 y 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opcion invalida. Por favor, ingrese un numero entre 1 y 3.");
                keyboard.next();
            }
        } while (input < 1 || input > 3);
        int cardType = input; 
        CreditCardType type = null;
        switch (cardType){
            case 1:
                type = CreditCardType.VISA;
            case 2:
                type = CreditCardType.NARA;
            case 3:
                type = CreditCardType.AMEX;
        }
        
        System.out.print("Ingrese el Nro de tarjeta:");
        String cardNumber;
        keyboard.nextLine();
        while (true) {
            cardNumber = keyboard.nextLine().trim();
            //Hay que validar 16 nros en la tarjeta pero para agilizar el testing solo valido nros -> [0-9]{16}
            if (cardNumber.matches("[0-9]+")) {
                break;
            } else {
                System.out.println("Nro de tarjeta invalido");
                System.out.print("Ingrese un Nro valido:");
            }
        }
        
        System.out.print("Ingrese la fecha de vencimiento (mm/yy):");
        String expirationDate = ValidExpirationDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        YearMonth expirationDateFormatted = YearMonth.parse(expirationDate, formatter);
        CardHolder cardHolderFinded;
        while (true) {
            System.out.print("Ingrese el DNI del responsable:");
            String dni = validDni();
            
            
            cardHolderFinded = searchCardHolder(dni);

            if (cardHolderFinded != null) {
                System.out.println("Se asignó como titular a " + cardHolderFinded.getName() + " " + cardHolderFinded.getLastName());
                break;
            } else {
                System.out.println("No se encontró una persona con el DNI " + dni + ".");
                System.out.println("Intente nuevamente.");
            }
        }
        String cvv = getCVV();
        
        CreditCard newCreditCard = new CreditCard(cardNumber, cardHolderFinded, expirationDateFormatted,cvv,type);
        cardsList.add(newCreditCard);
    }
    
    public static CardHolder searchCardHolder(String dni) {
        for (CardHolder cardHolder : cardHoldersList) {
            if (cardHolder.getDni().equals(dni)) {
                return cardHolder;
            }
        }
        return null;
    }
    
    public static void cardHolderCards(){
        System.out.print("Ingrese el DNI para comenzar la busqueda:");
        String dni = validDni();
        List<CreditCard> holderCards = new ArrayList<>();
        
         for (CreditCard card : cardsList) {
            if (card.getCardHolder().getDni().equals(dni)){
                holderCards.add(card);
            }
        }
        
        if (holderCards.isEmpty()){
             System.out.println("No se encontraron tarjetas asociadas con con el DNI " + dni + ".");   
        } else {
             System.out.println("Listado de tarjetas asociadas con el DNI: " + dni + ".");   
             System.out.println("-------------------------------------------------------");   
             
            for (CreditCard card : holderCards) {
                System.out.println(card.getNumber() + " " + card.CVV + " " + card.getType().toString() + " " + card.getExpirationDate() );   
            }
        }
    }
    
    public static CardHolder searchCards(String dni) {
      
        for (CardHolder cardHolder : cardHoldersList) {
            if (cardHolder.getDni().equals(dni)) {
                return cardHolder;
            }
        }
        return null;
    }
    
    public static String validDni(){
        Scanner keyboard = new Scanner(System.in);
        String dni;
        while (true) {
            dni = keyboard.nextLine();
            if (dni.matches("[0-9]+")) {
                break;
            } else {
                System.out.println("DNI inválido");
                System.out.print("Ingrese un DNI válido:");
            }
        }
        return dni;
    }
    
    public static int GetRandom(){
        Random random = new Random();
        return random.nextInt(10000);
    }
    
    public static String ValidExpirationDate(){
        Scanner keyboard = new Scanner(System.in);
        String expirationDate;
        while (true) {
            expirationDate = keyboard.nextLine();
            if (expirationDate.matches("\\d{2}/\\d{2}")){ 
                String[] parts = expirationDate.split("/");
                int month = Integer.parseInt(parts[0]);
                if (month >= 1 && month <= 12) {
                    break;
                } else {
                    System.out.println("Mes inválido. Debe estar entre 01 y 12.");
                    System.out.print("Ingrese una fecha valida:");
                }
            } else {
                System.out.println("Fecha inválida. Formato esperado: mm/yy.");
                System.out.print("Ingrese una fecha valida:");
            }
        }
        return expirationDate;
    }
    
    public static void RateConsult(){
       Scanner keyboard = new Scanner(System.in);
       int input = 5;
       do { 
            
            System.out.println("Consultar las tasas de cada tarjeta");
            System.out.println("1 - Por una fecha en especifico");
            System.out.println("2 - Hoy");
            try {
                input = keyboard.nextInt();
                if (input < 1 || input > 2) {
                    System.out.println("Opcion invalida. Por favor, ingrese un numero entre 1 y 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opcion invalida. Por favor, ingrese un numero entre 1 y 2.");
                keyboard.next();
            }
        } while (input < 1 || input > 2);             
        LocalDate consult;
        if (input == 1){
            System.out.println("Ingrese la fecha a consultar (formato dd/mm/yyyy)");
            String consultDate = ValidDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            consult = LocalDate.parse(consultDate, formatter);
             } else {
            consult = LocalDate.now();  
        }
        System.out.println("Las tasas para la fecha " + consult.toString() + " son las siguientes:");
        int year = consult.getYear();
        int month = consult.getMonthValue();
        int lastTwoDigitsOfYear = year % 100;
        
        System.out.println("VISA: " +  lastTwoDigitsOfYear  / month);
        System.out.println("NARA: " + consult.getDayOfMonth() * 0.5);
        System.out.println("AMEX: " + consult.getMonthValue() * 0.1);
    }
    
    public static String ValidDate(){
        Scanner keyboard = new Scanner(System.in);
        String birthDate;
        while (true) {
            birthDate = keyboard.nextLine();
            if (birthDate.matches("\\d{2}/\\d{2}/\\d{4}")) { 
                break;
            } else {
                System.out.println("Fecha inválida. Formato esperado: dd/mm/yyyy.");
                System.out.print("Ingrese una fecha valida.");
            }
        }
        return birthDate;
    }
    
    public static String getCVV() {
        Scanner keyboard = new Scanner(System.in);
        int cvv;

        while (true) {
            System.out.print("Ingrese el CVV (Numero de 3 dígitos):");
            if (keyboard.hasNextInt()) {
                cvv = keyboard.nextInt();
                if (cvv >= 100 && cvv <= 999) {
                    break;
                } else {
                    System.out.println("Número inválido. Debe ser un entero de 3 dígitos.");
                }
            } else {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
                keyboard.next();
            }
        }

        return Integer.toString(cvv);
    }
    
}
