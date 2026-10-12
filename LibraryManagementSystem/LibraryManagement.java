package com.gla.LibraryManagementSystem;

class LibraryManagement {
    public static class Book {
        int BookId;
        String Title;
        String author;
        double price;

        public Book(int BookId, String Title, String author, double price) {
         this.BookId=BookId;
         this.Title=Title;
         this.author=author;
         this.price=price;
        }
    }
    public static int removeDuplicates(Book[] books,int n) {
        if (n == 0)
            return 0;
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (books[i].BookId != books[j].BookId) {
                j++;
                books[j] = books[i];
            }
        }
        return j + 1;
    }
    public static void searchByTitle(Book[] books,int count,String query)
    {
        System.out.println("/n Search results for '"+query+"':");
        for(int i=0;i<count;i++)
        {
            if(books[i].Title.toLowerCase().contains(query.toLowerCase()))
            {
                System.out.println("-Found: ["+books[i].BookId+"] "+books[i].Title+" (Rs. "+books[i].price+")");
            }
        }
    }
    public static void sortByPrice(Book[] books,int count)
    {
        int s=0;
        for(int i=0;i<count-1;i++)
        {
            int m=i;
            for(int j=i+1;j<count;j++)
            {
                if(books[m].price>books[j].price)
                {
                    m=j;
                }
            }
            if(m!=i)
            {
                Book t=books[i];
                books[i]=books[m];
                books[m]=t;
                s++;
            }
        }
        System.out.println("\nBooks Sorted by Price:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1)+". ["+books[i].BookId+"] "+books[i].Title+" - Rs. "+books[i].price);
        }
        System.out.println("Total Swaps: " + s);
    }
    public static int searchByPrice(Book[] books,int count,double targetPrice)
    {
          int s=0,e=count-1;
          while(s<=e) {

              int m =s+(e-s)/2;
              if(books[m].price==targetPrice)
              return m;
              if(books[m].price<targetPrice)
                  s=m+1;
              else
                  e=m-1;
          }
         return -1;
    }
    public static int minBooksForTargetCost(Book[] books,int count,double targetCost) {
        int left = 0;
        double sum = 0;
        int minLength = count + 1;
        for (int right = 0; right < count; right++) {
            sum += books[right].price;
            while (sum >= targetCost) {
                int length = right - left + 1;
                if (length < minLength) {
                    minLength = length;
                }
                sum -= books[left].price;
                left++;
            }
        }
        if (minLength == count + 1) {
            return 0;
        }
        return minLength;
    }
            public static void main(String[] args) {
                Book[] books = new Book[6];
                books[0] = new Book(101, "Data Structures", "Mark", 400.0);
                books[1] = new Book(101, "Data Structures", "Mark", 400.0);
                books[2] = new Book(102, "Java Basics", "James", 300.0);
                books[3] = new Book(103, "Python Guide", "Guido", 600.0);
                books[4] = new Book(104, "Database Systems", "Raghu", 500.0);
                books[5] = new Book(105, "Computer Networks", "Andrew", 700.0);
                int n = books.length;
                System.out.println("TASK 1: REMOVE DUPLICATES");
                n = removeDuplicates(books, n);
                System.out.println("Unique Books Count: " + n);
                for (int i = 0; i < n; i++) {
                    System.out.println("["+books[i].BookId+"] "+books[i].Title+" - Rs. "+books[i].price);
                }
                System.out.println("\nTASK 2: SEARCH BY TITLE");
                searchByTitle(books, n, "data");
                System.out.println("\nTASK 3: SORT BY PRICE");
                sortByPrice(books, n);
                System.out.println("\nTASK 4: SEARCH BY PRICE");
                double targetPrice = 500.0;
                System.out.println("Searching for Price Rs. "+targetPrice+"...");
                int index = searchByPrice(books, n, targetPrice);
                if (index != -1) {
                    System.out.println("Result: Book found at index "+index+": ["+books[index].BookId+"] "+books[index].Title+" (Rs. "+books[index].price+")");
                } else {
                    System.out.println("Book not found.");
                }
                System.out.println("\nTASK 5: SLIDING WINDOW");
                double targetCost = 1000.0;
                System.out.println("Finding minimum consecutive books whose "+"total price >= Rs. "+targetCost+"...");
                int result = minBooksForTargetCost(books, n, targetCost);
                System.out.println("Minimum Consecutive Books Needed: " + result);
            }
}
