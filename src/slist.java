

    public class slist  {

        private Node head;
        private int length;

        // initialize the list
        public slist() {
            head = null;
            length = 0;
        }



        // create method to add name, email, and phone number in String form
        public void add(String firstname, String lastname, String email, String homenumber, String phoneNumber, String profession) {

            boolean empty = true;
            Node current = head;
            Node previous = null;
            Node newNode = new Node();
            // Set the data

            newNode.setFirstName(firstname);
            newNode.setLastName(lastname);
            newNode.setEmail(email);
            newNode.setHomeNumber(homenumber);
            newNode.setPhoneNumber(phoneNumber);
            newNode.setProfession(profession);
            // if the head is empty, new entry automatically becomes the head
            // and length is increased by one

            if (isEmpty()) {
                head = newNode;
                length++;
            } else {

                for (int i = 0; i < length; i++) {

                    // if last name entered goes before what's stored in
                    // the head, new entry becomes the head

                    if (empty == true) {
                        if (previous == null) {
                            newNode.setNext(current);
                            head = newNode;
                            length++;
                            break;
                        }

                        // this section cycles through the "body" of the nodes if
                        // it's not the tail
                        previous.setNext(newNode);
                        newNode.setNext(current);
                        length++;
                        break;
                        // if the entry replaces node at the tail, this

                        // entry becomes the new tail
                    } else {
                        if (current.getNext() == null) {
                            current.setNext(newNode);
                            newNode.setNext(null);
                            length++;
                            break;
                        }
                        // System.out.println("Add after");
                        previous = current;
                        current = current.getNext();

                    }
                }
            }
        }

	public void sortList() {

		// Node current will point to head
		Node current = head, index = null;
		int temp;
		if (head == null) {
			return;
		} else {
			while (current != null) {
				// Node index will point to node next to
				// current
				index = current.getNext();

				while (index != null) {
					// If current node's data is greater
					// than index's node data, swap the data
					// between them
					if (current.getFirstName() > index.getFirstName()) {
						temp = current.data;
						current.data = index.data;
						index.data = temp;
					}
					index = index.next;
				}
				current = current.next;
			}
		}
	}

        public void printList () {
            // start at the head and check if there's anything there
            Node tempNode = head;
            if (head == null) {
                System.out.println("The list is empty!");
            } else {
                // go through list and print in order
                for (int i = 0; i < length; i++) {
                    System.out.print("Index = " + (i+1) + " ");
                    System.out.println(tempNode);
                    tempNode = tempNode.getNext();
                }
            }
            System.out.println();
        }

        // method to use if the linked list is empty
        public boolean isEmpty() {
            return (length == 0);
        }

        // method used to search through the names in the string
        public void firstnameSearch(String firstname) {
            Node current = head;
            boolean empty = true;
            // check to see if the list is empty
            if (isEmpty()) {
                System.out.println("The list is empty!");
            }else {
                // check to see if input matches anything in the string
                for (int i = 0; i < length; i++) {
                    if (current.getFirstName().toLowerCase().contains(firstname.toLowerCase())) {
                        System.out.print("Index = " + (i+1) + " ");
                        System.out.println(current);
                        empty = false;

                    }
                    // if first string doesn't have desired search value
                    // go to the next node
                    current = current.getNext();
                }
                // if statement to show if there are no matches found
                if (empty){
                    System.out.println("No matches to that name!");
                }
            }
        }

        public void lastnameSearch(String lastname) {
            Node current = head;
            boolean empty = true;

            // check to see if the list is empty
            if (isEmpty()) {
                System.out.println("The list is empty!");
            }else {
                // check to see if input matches anything in the string
                for (int i = 0; i < length; i++) {
                    if (current.getLastName().toLowerCase().contains(lastname.toLowerCase())) {
                        System.out.print("Index = " + (i+1) + " ");
                        System.out.println(current);
                        empty = false;

                    }
                    // if first string doesn't have desired search value
                    // go to the next node
                    current = current.getNext();
                }
                // if statement to show if there are no matches found
                if (empty){
                    System.out.println("No matches to that name!");
                }
            }
        }

        // create method to search through list for email addresses
        public void emailSearch(String email) {
            Node current = head;
            boolean empty = true;
            // check to see if list is empty
            if (isEmpty()) {
                System.out.println("The list is empty!");
            }else {
                // check through first in list to see if desired search
                // matches first entry in list
                for (int i = 0; i < length; i++) {
                    if (current.getEmail().toLowerCase().contains(email.toLowerCase())) {
                        System.out.print("Index = " + (i+1) + " ");
                        System.out.println(current);
                        empty = false;
                    }
                    // if nothing in current node, set to next and search
                    // again
                    current = current.getNext();
                }
                // if statement if no emails match the desired search
                if (empty){
                    System.out.println("No matches to that email address!");
                }
            }
        }

        public void professionSearch(String profession) {
            Node current = head;
            boolean empty = true;
            // check to see if the list is empty
            if (isEmpty()) {
                System.out.println("The list is empty!");
            }else {
                // check to see if input matches anything in the string
                for (int i = 0; i < length; i++) {
                    if (current.getProfession().toLowerCase().contains(profession.toLowerCase())) {
                        System.out.print("Index = " + (i+1) + " ");
                        System.out.println(current);
                        empty = false;
                    }
                    // if first string doesn't have desired search value
                    // go to the next node
                    current = current.getNext();
                }
                // if statement to show if there are no matches found
                if (empty){
                    System.out.println("No matches to that name!");
                }
            }
        }

        // create method to delete entries by index
        public void delete (int index) {
            Node current = head;
            Node previous = null;
            boolean empty = true;
            // check to see if list is empty
            if (isEmpty()) {
                System.out.println("The list is empty!");
            } else {
                // iterates over and finds the index and deletes it
                for (int i = 0; i < length; i++) {
                    if ((index-1) == i) {
                        if (previous == null) {
                            head = head.getNext();
                            length--;
                            empty = false;
                            break;
                        } else if (current.getNext() == null){
                            previous.setNext(null);
                            length--;
                            empty = false;
                            break;
                        } else {
                            previous.setNext(current.getNext());
                            length--;
                            empty = false;
                            break;
                        }
                    } else {
                        previous = current;
                        current = current.getNext();
                    }
                }
                if (empty){
                    System.out.println("Index Does Not Exist!");
                } else {
                    // notification of successful deletion of index
                    System.out.println("Successfully deleted index " + index);
                }
            }
        }
    }


