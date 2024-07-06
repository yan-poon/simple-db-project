DROP TABLE COIN;
CREATE TABLE COIN ( 
   id BIGINT NOT NULL auto_increment, 
   coinmarketcap_id INT NOT NULL,
   name VARCHAR(50) NOT NULL, 
   code VARCHAR(20) NOT NULL, 
   description VARCHAR(2000)
);
insert into coin(coinmarketcap_id,name,code,description) values(1,'Bitcoin','BTC','Bitcoin (BTC) is a cryptocurrency launched in 2010. Users are able to generate BTC through the process of mining. Bitcoin has a current supply of 19,715,250. The last known price of Bitcoin is 64,303.32159425 USD and is up 0.74 over the last 24 hours. It is currently trading on 11132 active market(s) with $23,336,155,032.18 traded over the last 24 hours. More information can be found at https://bitcoin.org/.');
insert into coin(coinmarketcap_id,name,code,description) values(825,'Tether USDt','USDT','Tether USDt (USDT) is a cryptocurrency and operates on the Ethereum platform. Tether USDt has a current supply of 116,079,124,154.2462 with 112,941,691,562.69733 in circulation. The last known price of Tether USDt is 0.99955043 USD and is up 0.03 over the last 24 hours. It is currently trading on 89315 active market(s) with $31,687,001,823.44 traded over the last 24 hours. More information can be found at https://tether.to.');