package com.enums;
 //enum with methods
public enum AirSignal {
    STEADY_GREEN {
        @Override
        public void getMessage() {
            System.out.println("Cleared to land");
        }
    },
    FLASHING_GREEN {
        @Override
        public void getMessage() {
            System.out.println("Return for landing");
        }
    },
    STEADY_RED {
        @Override
        public void getMessage() {
            System.out.println("Give way to other aircraft and continue circling");
        }
    },
    FLASHING_RED {
        @Override
        public void getMessage() {
            System.out.println("Airport unsafe, do not land");
        }


    };
     public  abstract void getMessage();



 }
