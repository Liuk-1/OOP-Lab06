package it.unibo.oop.lab.exception2;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	AccountHolder person1 = new AccountHolder("Mario", "Rossi", 126);
    	AccountHolder person2 = new AccountHolder("Luca", "Bianchi", 99);
    	
    	StrictBankAccount bankAccount1 = new StrictBankAccount(126, 1000, 10);
    	StrictBankAccount bankAccount2 = new StrictBankAccount(99, 1000, 10);
    	
    	try {
    		for(int i = 0; i < 20; i++) {
    			bankAccount1.depositFromATM(126, 10);
    		}
    	}catch(NotEnoughFoundsException | WrongAccountHolderException | TransactionsOverQuotaException e){
    		System.out.println(e.toString());
    	}
    	
    	try {
    		bankAccount1.deposit(30, 500.00);
    	}catch(WrongAccountHolderException e) {
    		System.out.println(e.toString());
    	}
    	
    	try {
    		for(int i = 0; i < 3; i++) {
    			bankAccount2.withdrawFromATM(99, 500);
    		}
    	}catch(NotEnoughFoundsException | WrongAccountHolderException | TransactionsOverQuotaException e){
    		System.out.println(e.toString());
    	}
    	
    }
}
