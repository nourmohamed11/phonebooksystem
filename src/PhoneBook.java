import java.util.Scanner ;
    public class PhoneBook {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            String[] FirstName = new String[1001];
            String[] lastName = new String[1001];
            int[] phoneNumber = new int[1001];
            String[] address = new String[1001];
            String [] email = new String[1001];
            String [] profession = new String[1001];
            int [] HomeNumber = new int [1001];

            int x = 0 ;
            while (x != -1) {
                System.out.println("--------------------------------------------");
                System.out.println("enter 1 to add Number ");
                System.out.println("enter 2 to search for Name .");
                System.out.println("enter 3 to edit .");
                System.out.println("enter 4 to see all names ");
                System.out.println("enter 5 to delete a name .");
                System.out.println("enter -1 to finish .");
                System.out.println("--------------------------------------------");

                x = input.nextInt();

                switch(x) {
                    case 1 :
                        int number = addUser (phoneNumber , FirstName , lastName, address , email , profession) ;
                        sort(FirstName , lastName,address ,phoneNumber , number , email , HomeNumber , profession);
                        break ;
                    case 2 :
                        search(FirstName , lastName,address ,phoneNumber , email , profession, HomeNumber, profession);
                        break ;

                    case 3 :
                        edit(FirstName , lastName,address ,phoneNumber , email , profession , HomeNumber);
                        break ;

                    case 4 :
                        printAllNames(FirstName , lastName,address ,phoneNumber , email , profession , HomeNumber);
                        break ;

                    case 5 :
                        delete(FirstName);
                }
            }
        }
        public static int addUser(int[] phoneNumber, String[] FirstName, String[] lastName, String[] address, String[] email, String[] profession) {
            Scanner input = new Scanner(System.in);
            int i = 0 ;
            int n = 0 ;
            int count = 1 ;

            while(n != -1 ) {

                System.out.println("--------------------------------------------");
                System.out.print("first name : ");
                FirstName[i] = input.next();
                StringValidation(FirstName[i]);

                System.out.print("last name : ");
                lastName[i] = input.next();
                StringValidation(lastName[i]);

                System.out.print("address : ");
                address[i] = input.next() ;

                System.out.print("Phone number : ");
                String PhoneNumber = input.next();
                IntValidation(PhoneNumber);
                phoneNumber[i] = StringToInt(PhoneNumber);

                System.out.println("E-mail : ");
                email[i] = input.next();
                StringValidation(email[i]);

                System.out.println("profession");
                profession[i] = input.next();
                StringValidation(profession[i]);



                System.out.println("--------------------------------------------");

                System.out.println("enter 1 to continue .");
                System.out.println("enter -1 to finish .");

                System.out.println("--------------------------------------------");

                n = input.nextInt();
                if ( n == 1) {
                    count ++ ;
                }
                i++ ;
            }
            return count ;
        }
        public static void search(String[] FirstName, String[] lastName, String[] address, int[] phoneNumber, String[] strings, String[] email, int[] homeNumber ,String [] profession) {
            int count = 0 ;
            Scanner input = new Scanner(System.in);
            String name = input.next();
            for (int i = 0 ; i < FirstName.length ; i++) {
                if (name.equals(FirstName[i]) ) {
                    System.out.println("--------------------------------------------");
                    System.out.println("First Name : " + FirstName[i]);
                    System.out.println("last Name : "+ lastName[i]);
                    System.out.println("address : " + address[i]);
                    System.out.println("Phone Number : " + phoneNumber[i]);
                    System.out.println("Home Number :" + homeNumber[i]);
                    System.out.println("E-mail : " + email[i]);
                    System.out.println("profession : " + profession[i] );
                    System.out.println("--------------------------------------------");
                }
                else {
                    count ++ ;
                }
            }
            if (count == FirstName.length) {
                System.out.println("couldn't find name in database .");
            }
        }
        public static void sort(String[] FirstName, String[] lastName, String[] address, int[] phoneNumber, int number, String[] email, int[] homeNumber, String[] profession) {
            for (int i= 0 ; i < number - 1; i++ ) {
                for (int x = 0 ; x < number-i-1 ; x++) {
                    if (FirstName[x].charAt(0) > FirstName[x+1].charAt(0) ) {

                        String n = FirstName[x] ;
                        FirstName[x]=FirstName[x+1];
                        FirstName[x+1] = n ;

                        String m = lastName[x] ;
                        lastName[x]= lastName[x+1];
                        lastName[x+1] = m ;

                        String v = address[x] ;
                        address[x]=address[x+1];
                        address[x+1] = v ;

                        int k = phoneNumber[x] ;
                        phoneNumber[x]=phoneNumber[x+1];
                        phoneNumber[x+1] = k ;

                        int d = homeNumber[x];
                        homeNumber[x]=homeNumber[x+1];
                        homeNumber[x+1] = d;

                        String e = email[x];
                        email[x] =email[x+1];
                        email[x+1] = e ;

                        String f = profession[x];
                        profession[x] =profession[x+1];
                        profession[x+1] = f ;
                    }
                }
            }
        }
        public static void edit(String[] FirstName, String[] lastName, String[] address, int[] phoneNumber, String[] email, String[] profession, int[] homeNumber) {
            Scanner input = new Scanner (System.in);
            int count = 0 ;

            System.out.println("enter name of user that you want to edit : ");
            String name  = input.next() ;

            for (int i = 0 ; i < FirstName.length ; i++) {
                if (name.equals(FirstName[i]) ) {
                    System.out.println("--------------------------------------------");

                    System.out.println("enter new data : ");
                    System.out.println();

                    System.out.print("first name : ");
                    FirstName[i] = input.next();

                    System.out.print("last name : ");
                    lastName[i] = input.next();

                    System.out.print("address : ");
                    address[i] = input.next() ;

                    System.out.print("Phone number : ");
                    phoneNumber[i] = input.nextInt();

                    System.out.println("E-mail : ");
                    email[i] = input.next();

                    System.out.println("--------------------------------------------");

                }
                else {
                    count ++ ;
                }
            }
            if (count == FirstName.length) {
                System.out.println("couldn't find name in database .");
            }

        }
        public static void printAllNames(String[] FirstName, String[] lastName, String[] address, int[] phoneNumber, String[] email, String[] profession, int[] homeNumber) {


            for (int i = 0 ; i < FirstName.length ; i++) {
                if( FirstName[i] != null ) {

                    System.out.println("--------------------------------------------");

                    System.out.println("First Name : " + FirstName[i]);
                    System.out.println("last Name : "+ lastName[i]);
                    System.out.println("address : " + address[i]);
                    System.out.println("Phone Number : " + phoneNumber[i]);
                    System.out.println("E-mail : " + email[i]);

                    System.out.println("--------------------------------------------");
                }
            }
        }
        public static void StringValidation (String word) {
            Scanner input = new Scanner(System.in);
            boolean validation = false ;

            while (validation == false) {

                char[] str = new char[word.length()];
                word = word.toLowerCase() ;

                for (int i = 0 ; i < str.length ; i++) {
                    str[i] = word.charAt(i) ;
                }

                for (int i = 0 ; i < str.length ; i++) {

                    if(!(str[i] >= 'a' && str[i] <='z')) {
                        System.out.println("enter a valid name without numbers :  ");
                        word = input.next();
                        validation = false ;

                    }

                    else {

                        validation = true ;
                    }
                }
            }
        }
        public static void IntValidation(String a ) {
            Scanner console = new Scanner(System.in);
            boolean validation = false ;
            while (validation == false ) {
                char[] num = new char[a.length()];
                for(int i = 0 ; i < num.length ; i++) {
                    num[i] = a.charAt(i);
                }
                for(int i = 0 ; i < num.length ; i++) {
                    if(!(num[i] >='0' && num[i]<= '9' || num[i] == ' ')) {
                        System.out.print("enter a valid number without letters");
                        a = console.next();
                        validation = false ;
                    }
                    else {
                        validation = true ;
                    }
                }
            }
        }
        public static int StringToInt(String a) {
            int num = 0 ;
            for (int i = 0 ; i < a.length()  ; i++) {
                num = num * 10 +((int)a.charAt(i)-48);
            }
            return num ;
        }
        public static void delete(String[] FirstName ) {
            int count = 0 ;
            Scanner input = new Scanner(System.in);
            String name = input.next();
            for (int i = 0 ; i < FirstName.length ; i++) {
                if (name.equals(FirstName[i]) ) {
                    System.out.println("to delete " + FirstName[i] + " enter y to cancel enter n");
                    char x  = input.next().charAt(0);

                    if ( x == 'y' || x == 'Y') {
                        FirstName[i] = null ;

                    }
                    else if (x == 'n' || x == 'N') {
                        break ;
                    }
                }
                else {
                    count ++ ;
                }
            }
            if (count == FirstName.length) {
                System.out.println("couldn't find name in database .");
            }
        }

    }

