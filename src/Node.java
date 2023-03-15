public class Node {


        private String firstname;
        private String lastname;
        private String email;
        private String homeNumber;
        private String phoneNumber;
        private String profession;
        private Node next;

        public Node() {
            next = null;
        }


        public String getFirstName() {
            return firstname;
        }

        public void setFirstName(String firstname) {
            this.firstname = firstname;
        }

        public String getLastName() {
            return lastname;
        }

        public void setLastName(String lastname){
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getHomeNumber(){
            return homeNumber;
        }

        public void setHomeNumber(String homeNumber){
            this.homeNumber = homeNumber;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getProfession(){
            return profession;
        }

        public void setProfession(String profession){
            this.profession = profession;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "First Name = " + firstname + ", Last Name = "+ lastname + ", Email = " + email + ", Home Number = "
                    + homeNumber+ ", Phone Number = " + phoneNumber + ", Profession = " + profession;
        }
    }



