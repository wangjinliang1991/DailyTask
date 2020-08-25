package com.ai.dm01.junit;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/1
 * @Version: 1.0
 **/

public class Transaction {
    
    /*protected boolean isExpired(){
        long executionInvokedTimestamp = System.currentTimeMillis();
        return executionInvokedTimestamp - createTimestamp >14days;
    }
    
    public boolean execute() throws InvalidTransactionException{
        //...
        if(isExpired()){
            this.status = STATUS.EXPIRED;
            return false;
        }
        //...
    }
    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private String orderId;
    private Long createTimestamp;
    private Double amount;
    private STATUS status;
    private String walletTransactionId;

    // ...get() methods...

    public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId, String orderId) {
        //...
        fillTransactionId(preAssignedId);
        //...
        
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = STATUS.TO_BE_EXECUTD;
        this.createTimestamp = System.currentTimestamp();
    }
    
    protected void fillTransactionId(String preAssignedId){
        if (preAssignedId != null && !preAssignedId.isEmpty()) {
            this.id = preAssignedId;
        } else {
            this.id = IdGenerator.generateTransactionId();
        }
        if (!this.id.startWith("t_")) {
            this.id = "t_" + preAssignedId;
        }
    }

    public boolean execute() throws InvalidTransactionException {
        if ((buyerId == null || (sellerId == null || amount < 0.0) {
            throw new InvalidTransactionException(...);
        }
        if (status == STATUS.EXECUTED) return true;
        boolean isLocked = false;
        try {
            isLocked = RedisDistributedLock.getSingletonIntance().lockTransction(id);
            if (!isLocked) {
                return false; // 锁定未成功，返回false，job兜底执行
            }
            if (status == STATUS.EXECUTED) return true; // double check
            long executionInvokedTimestamp = System.currentTimestamp();
            if (executionInvokedTimestamp - createdTimestap > 14days) {
                this.status = STATUS.EXPIRED;
                return false;
            }
            WalletRpcService walletRpcService = new WalletRpcService();
            String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
            if (walletTransactionId != null) {
                this.walletTransactionId = walletTransactionId;
                this.status = STATUS.EXECUTED;
                return true;
            } else {
                this.status = STATUS.FAILED;
                return false;
            }
        } finally {
            if (isLocked) {
                RedisDistributedLock.getSingletonIntance().unlockTransction(id);
            }
        }
    }
    
    public void testExecute(){
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 456L;
        
        TransactionLock mockLock = new TransactionLock(){
            public boolean lock(String id){
                return true;
            }
            
            public void unlock(){
                
            }
        };
        
        Transaction transaction = new Transaction(null,buyerId,sellerId,productId,orderId);
        transaction.setWalletRpcService(new MockWalletRpcServiceOne());
        transaction.setTransactionLock(mockLock);
        boolean executedResult = transaction.execute();
        assertTrue(executedResult);
        assertEquals(STATUS.EXECUTED,transaction.getStatus());
    }
    
    public void testExecute_with_TransactionIsExpired(){
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 456L;
        Transaction transaction = new Transaction(null,buyerId,sellerId,productId,orderId){
            protected boolean isExpired(){
                return true;
            }
        };
        boolean actualResult = transaction.execute();
      
    }*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
