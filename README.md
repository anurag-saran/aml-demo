# aml-demo
Hadoop AML Setup
================
In this demo we will create a banking customer profile. This will allow us to use historical data to build a profile of a customer. First we will upload our data to the Hadoop cluster and use pig from grunt> command line. Then we will create a MapReduce job to calculate the customer profile based on zip, occupation, time. Finally we will integrate Drools with our MapReduce job to generate the decesion table.

## Prerequisitse ##
1. Download [VirtualBox](https://www.virtualbox.org/wiki/Linux_Downloads)
2. Download [Hortonworks Sandbox For VirtualBox](http://hortonworks.com/products/hortonworks-sandbox/#install)

## Start the Hadoop Cluster ##
1. Install VirtualBox 
  * You might need to run `/etc/init.d/vboxdrv setup'
    * You will need to make sure gcc is installed with `sudo yum install gcc`
    * You will need to make sure your kernel source/headers are installed with `sudo yum install kernel-devel kernel-headers`
2. Import Hortworks appliance into VirtualBox, default values are fine
3. Start Hortonworks VM
4. Navigate to http://localhost:8000 to view Hue (Web interface for Hadoop)
5. Verify that you can SSH into the vm on port 2222 with user:`root` and pass:`hadoop`

    ```shell
    [anuragsaran@localhost hadoop-lab]$ ssh root@localhost -p 2222
    ```

6. To get to the grunt command lime use the below command.
    ```shell
    [anuragsaran@localhost hadoop]$ ssh root@localhost -p 2222
    [root@sandbox ~]# pig -x mapreduce
    ```

## Upload the data ##
1. Inspect the trans.csv and account.csv file to discover the format. Please create a new directory aml-demo. user /user/aml-demo

    ```shell
    [anuragsaran@localhost hadoop]$ cat trans.csv
    [anuragsaran@localhost hadoop]$ cat account.csv
    ```
2. Navigate to the directory 
     ```shell
    grunt> cd /user/aml-demo
    grunt> ls
      hdfs://sandbox.hortonworks.com:8020/user/aml-demo/account.txt<r 1>	339
      hdfs://sandbox.hortonworks.com:8020/user/aml-demo/trans.txt<r 1>	419

    grunt> transaction = load 'trans.txt' using PigStorage(',') as               (TransactionID:int,AccountNo:int,FirstName:chararray,LastName:chararray,Amount:int,TransactionType:chararray,FromZipCode:chararray, ToZipCode:chararray,IPAddress:chararray,DeviceLocation:chararray,Country:chararray,State:chararray);

grunt> describe transaction
      transaction: {TransactionID: int,AccountNo: int,FirstName: chararray,LastName: chararray,Amount: int,TransactionType:         chararray,FromZipCode: chararray,ToZipCode: chararray,IPAddress: chararray,DeviceLocation: chararray,Country:           chararray,State: chararray}

    grunt> dump transaction
    
    2015-07-20 18:16:14,510 [main] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to     process : 1
    (10000001,214412,Anurag,Saran,500,CR,18821,192.168.1.21,Bank,US,NY,)
    (10000002,12,David,Murphy,300,DR,18821,192.168.1.44,ATM,US,NY,)
    (10000003,13,Josh,West,700,CC,18821,192.168.1.67,Food,US,NY,)
    (10000004,14,Derrick,Kittler,900,MoneyTransfer,8820,60090,192.168.1.90,iPhone,US,NJ)
    (10000005,12,David,Murphy,350,MoneyTransfer,60091,60090,192.168.1.113,AnroidPhone,US,IL)
    (10000006,12,David,Murphy,350,DR,60091,,192.168.1.114,ATM,US,IL)

    grunt> 
    grunt> account = load 'account.txt' using PigStorage(',') as (AccountNo:int, FirstName:chararray, LastName:chararray,         Street:chararray, City:chararray, State:chararray, ZipCode:chararray, Occupation:chararray, Age:int, Sex:chararray,           MaritalStatus:chararray, AccountType:chararray);
    grunt> C = foreach account generate AccountNo as id, ZipCode,Occupation;
    grunt> jnd = join transaction by AccountNo, C by id;
    grunt> D = group jnd by (C::ZipCode,transaction::TransactionType,C::Occupation);
    grunt> E = foreach D generate
    >> flatten(group) as (zip,Tranaction,occupation),
    >> SUM($1.Amount) as total_spent,
    >> COUNT(jnd) as numOfTransactions,
    >> AVG($1.Amount) as avg;
    grunt> dump E;
    
    (10039,CC,GasStation,700,1,700.0)
    (10039,DR,IceCreamShop,650,2,325.0)
    (10039,MoneyTransfer,CarWash,900,1,900.0)
    (10039,MoneyTransfer,IceCreamShop,350,1,350.0)
    ```
3. 
