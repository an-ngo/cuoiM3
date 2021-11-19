package model;

public class Book {

        private int idBook;
        private String name;
        private String author;
        private String description;
        private int value;

        public Book(int idBook, String name, String author, String description, int value) {
            this.idBook = idBook;
            this.name = name;
            this.author = author;
            this.description = description;
            this.value = value;
        }

        public int getIdBook() {
            return idBook;
        }

        public void setIdBook(int idBook) {
            this.idBook = idBook;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "idBook=" + idBook +
                    ", name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    ", description='" + description + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

