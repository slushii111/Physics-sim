/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ui;

/**
 *
 * @author jnesis
 */
public class MovingObjectAnimator implements Runnable{
    
    private MovingObject movingObject;
    private int movePerSec=100;
    
    public MovingObjectAnimator(MovingObject movingObject){
        this.movingObject=movingObject;
    }

    public int getMovePerSec() {
        return movePerSec;
    }

    /***
     * this method sets the movement per second for the instance. This is called in FirstWindow
     * @param movePerSec
     */
    public void setMovePerSec(int movePerSec) {
        this.movePerSec = movePerSec;
    }
    
    

    @Override
    public void run() {
        while (true){
            movingObject.move();
            try {
                //move every movePerSec.
                Thread.sleep(1000/movePerSec);

            } catch (InterruptedException ex) {
                if (Thread.currentThread().isInterrupted()){
                    return;
                }
                System.out.println("Something interrupted me while sleeping...");
            }
        }
    }
    
}
