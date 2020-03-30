package ru.sbdh.app.models.yandex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserYandex2 {
    private float page;
    private float per_page;
    private float pages;
    private float total;
    private boolean multishard;
    private Result[] result;


    // Getter Methods

    public float getPage() {
        return page;
    }

    public float getPer_page() {
        return per_page;
    }

    public float getPages() {
        return pages;
    }

    public float getTotal() {
        return total;
    }

    public boolean getMultishard() {
        return multishard;
    }

    // Setter Methods

    public void setPage(float page) {
        this.page = page;
    }

    public void setPer_page(float per_page) {
        this.per_page = per_page;
    }

    public void setPages(float pages) {
        this.pages = pages;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setMultishard(boolean multishard) {
        this.multishard = multishard;
    }

    public Result[] getResult() {
        return result;
    }

    public void setResult(Result[] result) {
        this.result = result;
    }

    public class Result {
        private String gender;
        private float id;
        Name name;
        private String position = null;
        private Contacts[] contacts;

        public class Contacts {
            private String type;
            private String value;
            private boolean main;
            private boolean alias;
            private boolean synthetic;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public boolean isMain() {
                return main;
            }

            public void setMain(boolean main) {
                this.main = main;
            }

            public boolean isAlias() {
                return alias;
            }

            public void setAlias(boolean alias) {
                this.alias = alias;
            }

            public boolean isSynthetic() {
                return synthetic;
            }

            public void setSynthetic(boolean synthetic) {
                this.synthetic = synthetic;
            }
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public float getId() {
            return id;
        }

        public void setId(float id) {
            this.id = id;
        }

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public Contacts[] getContacts() {
            return contacts;
        }

        public void setContacts(Contacts[] contacts) {
            this.contacts = contacts;
        }
    }

    public class Name {
        private String last;
        private String first;
        private String middle;


        // Getter Methods

        public String getMiddle() {
            return middle;
        }

        public void setMiddle(String middle) {
            this.middle = middle;
        }

        public String getLast() {
            return last;
        }

        public String getFirst() {
            return first;
        }

        // Setter Methods

        public void setLast(String last) {
            this.last = last;
        }

        public void setFirst(String first) {
            this.first = first;
        }
    }
}
