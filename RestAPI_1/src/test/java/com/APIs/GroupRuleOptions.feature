Feature: Group Rule Options

  Scenario Outline: 3368_Retrieve each rule APIs
    Given version of API and token are set
    When send a request to retrieve result of each "<apiQuery>"
    Then collect the response of each api.
    Examples:
      |apiQuery                                                        |
      |groups/ruleDefinitions/1/components/5001/options                |
      |groups/ruleDefinitions/7/components/5001/options                |
      |groups/ruleDefinitions/8/components/5001/options                |
      |groups/ruleDefinitions/9/components/5001/options                |
      |groups/ruleDefinitions/10/components/5001/options               |
      |groups/ruleDefinitions/11/components/5001/options               |
      |groups/ruleDefinitions/12/components/5001/options               |
      |groups/ruleDefinitions/13/components/5001/options               |
      |groups/ruleDefinitions/15/components/5001/options               |
      |groups/ruleDefinitions/16/components/5001/options               |
      |groups/ruleDefinitions/17/components/5001/options               |
      |groups/ruleDefinitions/20/components/5001/options               |
      |groups/ruleDefinitions/20/components/5002/options?parentId=1    |
      |groups/ruleDefinitions/20/components/5002/options?parentId=2    |
      |groups/ruleDefinitions/20/components/5002/options?parentId=3    |
      |groups/ruleDefinitions/20/components/5002/options?parentId=4    |
      |groups/ruleDefinitions/20/components/5002/options?parentId=5    |
      |groups/ruleDefinitions/20/components/5002/options?parentId=6    |
      |groups/ruleDefinitions/22/components/5001/options               |
      |groups/ruleDefinitions/22/components/5002/options?parentId=1    |
      |groups/ruleDefinitions/22/components/5002/options?parentId=4    |
      |groups/ruleDefinitions/22/components/5002/options?parentId=5    |
      |groups/ruleDefinitions/22/components/5002/options?parentId=2    |
      |groups/ruleDefinitions/24/components/5001/options               |
      |groups/ruleDefinitions/24/components/5002/options?parentId=1    |
      |groups/ruleDefinitions/24/components/5002/options?parentId=4    |
      |groups/ruleDefinitions/24/components/5002/options?parentId=5    |
      |groups/ruleDefinitions/24/components/5002/options?parentId=2    |
      |groups/ruleDefinitions/26/components/5001/options               |
      |groups/ruleDefinitions/26/components/5002/options?parentId=1    |
      |groups/ruleDefinitions/26/components/5002/options?parentId=4    |
      |groups/ruleDefinitions/26/components/5002/options?parentId=5    |
      |groups/ruleDefinitions/26/components/5002/options?parentId=2    |
      |groups/ruleDefinitions/28/components/5001/options               |
      |groups/ruleDefinitions/29/components/5001/options               |
      |groups/ruleDefinitions/30/components/5001/options               |
      |groups/ruleDefinitions/31/components/5001/options               |
      |groups/ruleDefinitions/32/components/5001/options               |
      |groups/ruleDefinitions/33/components/5001/options               |
      |groups/ruleDefinitions/34/components/5001/options               |
      |groups/ruleDefinitions/35/components/5001/options               |
      |groups/ruleDefinitions/36/components/5001/options               |
      |groups/ruleDefinitions/37/components/5001/options               |
      |groups/ruleDefinitions/41/components/5001/options               |
      |groups/ruleDefinitions/42/components/5001/options               |
      |groups/ruleDefinitions/43/components/5001/options               |
      |groups/ruleDefinitions/44/components/5001/options               |
      |groups/ruleDefinitions/45/components/5001/options               |
      |groups/ruleDefinitions/45/components/5002/options?parentId=1    |
      |groups/ruleDefinitions/45/components/5002/options?parentId=5    |
      |groups/ruleDefinitions/45/components/5002/options?parentId=3    |
      |groups/ruleDefinitions/45/components/5002/options?parentId=2    |
      |groups/ruleDefinitions/45/components/5002/options?parentId=4    |
      |groups/ruleDefinitions/46/components/5001/options               |
      |groups/ruleDefinitions/46/components/5002/options               |
      |groups/ruleDefinitions/47/components/5001/options               |
      |groups/ruleDefinitions/48/components/5001/options               |
      |groups/ruleDefinitions/49/components/5001/options               |
      |groups/ruleDefinitions/50/components/5001/options               |
      |groups/ruleDefinitions/51/components/5001/options               |
      |groups/ruleDefinitions/52/components/5001/options               |
      |groups/ruleDefinitions/53/components/5001/options               |
      |groups/ruleDefinitions/54/components/5001/options               |
      |groups/ruleDefinitions/59/components/5001/options               |
      |groups/ruleDefinitions/60/components/5001/options               |
      |groups/ruleDefinitions/61/components/5001/options               |
      |groups/ruleDefinitions/62/components/5001/options               |
      |groups/ruleDefinitions/63/components/5001/options               |
      |groups/ruleDefinitions/64/components/5001/options               |
      |groups/ruleDefinitions/65/components/5001/options               |
      |groups/ruleDefinitions/67/components/5001/options               |
      |groups/ruleDefinitions/68/components/5001/options               |
      |groups/ruleDefinitions/69/components/5001/options               |
      |groups/ruleDefinitions/70/components/5001/options               |
      |groups/ruleDefinitions/71/components/5001/options               |
      |groups/ruleDefinitions/72/components/5001/options               |
      |groups/ruleDefinitions/73/components/5001/options               |
      |groups/ruleDefinitions/74/components/5001/options               |
      |groups/ruleDefinitions/75/components/5001/options               |
      |groups/ruleDefinitions/81/components/5001/options               |
      |groups/ruleDefinitions/83/components/5001/options               |
      |groups/ruleDefinitions/84/components/5001/options               |
      |groups/ruleDefinitions/85/components/5001/options               |
      |groups/ruleDefinitions/85/components/5002/options?parentId=4    |
      |groups/ruleDefinitions/85/components/5002/options?parentId=2    |
      |groups/ruleDefinitions/85/components/5002/options?parentId=5    |
      |groups/ruleDefinitions/85/components/5002/options?parentId=3    |
      |groups/ruleDefinitions/85/components/5002/options?parentId=1    |
      |groups/ruleDefinitions/86/components/5001/options               |
      |groups/ruleDefinitions/86/components/5002/options               |
      |groups/ruleDefinitions/87/components/5001/options               |
      |groups/ruleDefinitions/88/components/5001/options               |
      |groups/ruleDefinitions/94/components/5001/options               |
      |groups/ruleDefinitions/95/components/5001/options               |
      |groups/ruleDefinitions/104/components/5001/options              |
      |groups/ruleDefinitions/107/components/5001/options              |
      |groups/ruleDefinitions/108/components/5001/options              |
      |groups/ruleDefinitions/110/components/5001/options              |
      |groups/ruleDefinitions/111/components/5001/options              |
      |groups/ruleDefinitions/112/components/5001/options              |
      |groups/ruleDefinitions/116/components/5001/options              |
      |groups/ruleDefinitions/117/components/5000/options              |
      |groups/ruleDefinitions/118/components/5000/options              |
      |groups/ruleDefinitions/118/components/5002/options              |
      |groups/ruleDefinitions/119/components/5000/options              |
      |groups/ruleDefinitions/120/components/5000/options              |
      |groups/ruleDefinitions/121/components/5000/options              |
      |groups/ruleDefinitions/122/components/5000/options              |
      |groups/ruleDefinitions/122/components/5002/options              |
      |groups/ruleDefinitions/123/components/5000/options              |
      |groups/ruleDefinitions/124/components/5000/options              |
      |groups/ruleDefinitions/125/components/5000/options              |
      |groups/ruleDefinitions/126/components/5000/options              |
      |groups/ruleDefinitions/126/components/5002/options              |
      |groups/ruleDefinitions/127/components/5000/options              |
      |groups/ruleDefinitions/128/components/5000/options              |
      |groups/ruleDefinitions/129/components/5000/options              |
      |groups/ruleDefinitions/130/components/5000/options              |
      |groups/ruleDefinitions/130/components/5002/options              |
      |groups/ruleDefinitions/131/components/5000/options              |
      |groups/ruleDefinitions/132/components/5000/options              |
      |groups/ruleDefinitions/133/components/5001/options              |
      |groups/ruleDefinitions/135/components/5001/options              |
      |groups/ruleDefinitions/136/components/5001/options              |
      |groups/ruleDefinitions/137/components/5001/options              |
      |groups/ruleDefinitions/138/components/5001/options              |
      |groups/ruleDefinitions/140/components/5001/options              |
      |groups/ruleDefinitions/141/components/5001/options              |
      |groups/ruleDefinitions/142/components/5001/options              |
      |groups/ruleDefinitions/143/components/5001/options              |
      |groups/ruleDefinitions/144/components/5001/options              |
      |groups/ruleDefinitions/145/components/5001/options              |
      |groups/ruleDefinitions/146/components/5001/options              |
      |groups/ruleDefinitions/148/components/5001/options              |
      |groups/ruleDefinitions/149/components/5001/options              |
      |groups/ruleDefinitions/150/components/5001/options              |
      |groups/ruleDefinitions/151/components/5001/options              |
      |groups/ruleDefinitions/152/components/5001/options              |
      |groups/ruleDefinitions/153/components/5001/options              |
      |groups/ruleDefinitions/154/components/5001/options              |
      |groups/ruleDefinitions/155/components/5001/options              |
      |groups/ruleDefinitions/156/components/5001/options              |
      |groups/ruleDefinitions/157/components/5001/options              |
      |groups/ruleDefinitions/158/components/5001/options              |
      |groups/ruleDefinitions/159/components/5001/options              |
      |groups/ruleDefinitions/160/components/5001/options              |
      |groups/ruleDefinitions/161/components/5001/options              |
      |groups/ruleDefinitions/162/components/5001/options              |
      |groups/ruleDefinitions/163/components/5001/options              |
      |groups/ruleDefinitions/164/components/5001/options              |
      |groups/ruleDefinitions/165/components/5001/options              |
      |groups/ruleDefinitions/167/components/5001/options              |
      |groups/ruleDefinitions/168/components/5001/options              |
      |groups/ruleDefinitions/169/components/5001/options              |
      |groups/ruleDefinitions/170/components/5001/options              |
      |groups/ruleDefinitions/172/components/5001/options              |
      |groups/ruleDefinitions/173/components/5001/options              |
      |groups/ruleDefinitions/174/components/5001/options              |
      |groups/ruleDefinitions/174/components/5002/options              |
      |groups/ruleDefinitions/175/components/5001/options              |
      |groups/ruleDefinitions/176/components/5001/options              |
      |groups/ruleDefinitions/177/components/5001/options              |
      |groups/ruleDefinitions/178/components/5001/options              |
      |groups/ruleDefinitions/179/components/5001/options              |
      |groups/ruleDefinitions/181/components/5001/options              |
      |groups/ruleDefinitions/182/components/5001/options              |
      |groups/ruleDefinitions/185/components/5001/options              |
      |groups/ruleDefinitions/186/components/5001/options              |
      |groups/ruleDefinitions/187/components/5001/options              |
      |groups/ruleDefinitions/188/components/5001/options              |
      |groups/ruleDefinitions/189/components/5001/options              |
      |groups/ruleDefinitions/190/components/5001/options              |
      |groups/ruleDefinitions/191/components/5001/options              |
      |groups/ruleDefinitions/192/components/5001/options              |
      |groups/ruleDefinitions/193/components/5001/options              |
      |groups/ruleDefinitions/194/components/5001/options              |
      |groups/ruleDefinitions/195/components/5001/options              |
      |groups/ruleDefinitions/196/components/5001/options              |
      |groups/ruleDefinitions/197/components/5001/options              |
      |groups/ruleDefinitions/198/components/5001/options              |
      |groups/ruleDefinitions/199/components/5001/options              |
      |groups/ruleDefinitions/200/components/5001/options              |
      |groups/ruleDefinitions/201/components/5001/options              |
      |groups/ruleDefinitions/202/components/5001/options              |
      |groups/ruleDefinitions/203/components/5001/options              |
      |groups/ruleDefinitions/204/components/5001/options              |
      |groups/ruleDefinitions/205/components/5001/options              |
      |groups/ruleDefinitions/210/components/5001/options              |
      |groups/ruleDefinitions/212/components/5001/options              |
      |groups/ruleDefinitions/215/components/5001/options              |
      |groups/ruleDefinitions/216/components/5001/options              |
      |groups/ruleDefinitions/216/components/5002/options              |
      |groups/ruleDefinitions/217/components/5001/options              |
      |groups/ruleDefinitions/217/components/5002/options              |
      |groups/ruleDefinitions/218/components/5001/options              |
      |groups/ruleDefinitions/219/components/5001/options              |
      |groups/ruleDefinitions/220/components/5001/options              |
      |groups/ruleDefinitions/221/components/5001/options              |
      |groups/ruleDefinitions/222/components/5001/options              |
      |groups/ruleDefinitions/222/components/5002/options              |
      |groups/ruleDefinitions/226/components/5001/options              |
      |groups/ruleDefinitions/228/components/5001/options              |
      |groups/ruleDefinitions/229/components/5001/options              |
      |groups/ruleDefinitions/233/components/5001/options              |
      |groups/ruleDefinitions/234/components/5001/options              |
      |groups/ruleDefinitions/236/components/5001/options              |
      |groups/ruleDefinitions/237/components/5001/options              |
      |groups/ruleDefinitions/243/components/5001/options              |
      |groups/ruleDefinitions/246/components/5001/options              |
      |groups/ruleDefinitions/248/components/5001/options              |
      |groups/ruleDefinitions/249/components/5001/options              |
      |groups/ruleDefinitions/250/components/5001/options              |
      |groups/ruleDefinitions/251/components/5001/options              |
      |groups/ruleDefinitions/252/components/5001/options              |
      |groups/ruleDefinitions/252/components/5002/options              |
      |groups/ruleDefinitions/253/components/5001/options              |
      |groups/ruleDefinitions/254/components/5001/options              |
      |groups/ruleDefinitions/255/components/5001/options              |
      |groups/ruleDefinitions/256/components/5001/options              |
      |groups/ruleDefinitions/257/components/5001/options              |
      |groups/ruleDefinitions/258/components/5001/options              |
      |groups/ruleDefinitions/259/components/5001/options              |
      |groups/ruleDefinitions/260/components/5001/options              |
      |groups/ruleDefinitions/260/components/5002/options              |
      |groups/ruleDefinitions/261/components/5001/options              |
      |groups/ruleDefinitions/262/components/5001/options              |
      |groups/ruleDefinitions/267/components/5001/options              |
      |groups/ruleDefinitions/268/components/5001/options              |
      |groups/ruleDefinitions/269/components/5001/options              |
      |groups/ruleDefinitions/269/components/5002/options              |
      |groups/ruleDefinitions/270/components/5001/options              |
      |groups/ruleDefinitions/271/components/5001/options              |
      |groups/ruleDefinitions/272/components/5001/options              |
      |groups/ruleDefinitions/273/components/5001/options              |
      |groups/ruleDefinitions/273/components/5002/options              |
      |groups/ruleDefinitions/278/components/5001/options              |
      |groups/ruleDefinitions/279/components/5001/options              |
      |groups/ruleDefinitions/280/components/5000/options              |
      |groups/ruleDefinitions/281/components/5000/options              |
      |groups/ruleDefinitions/281/components/5002/options              |
      |groups/ruleDefinitions/282/components/5000/options              |
      |groups/ruleDefinitions/283/components/5000/options              |
      |groups/ruleDefinitions/284/components/5001/options              |
      |groups/ruleDefinitions/285/components/5001/options              |
      |groups/ruleDefinitions/286/components/5001/options              |
      |groups/ruleDefinitions/287/components/5001/options              |
      |groups/ruleDefinitions/288/components/5001/options              |
      |groups/ruleDefinitions/288/components/5002/options              |
      |groups/ruleDefinitions/290/components/5001/options              |
      |groups/ruleDefinitions/292/components/5001/options              |
      |groups/ruleDefinitions/293/components/5001/options              |
      |groups/ruleDefinitions/295/components/5001/options              |
      |groups/ruleDefinitions/295/components/5002/options              |
      |groups/ruleDefinitions/297/components/5001/options              |
      |groups/ruleDefinitions/298/components/5001/options              |
      |groups/ruleDefinitions/299/components/5001/options              |
      |groups/ruleDefinitions/300/components/5001/options              |
      |groups/ruleDefinitions/300/components/5002/options              |
      |groups/ruleDefinitions/301/components/5001/options              |
      |groups/ruleDefinitions/302/components/5001/options              |
      |groups/ruleDefinitions/303/components/5001/options              |
      |groups/ruleDefinitions/304/components/5001/options              |
      |groups/ruleDefinitions/305/components/5001/options              |
      |groups/ruleDefinitions/305/components/5002/options              |
      |groups/ruleDefinitions/306/components/5001/options              |
      |groups/ruleDefinitions/307/components/5001/options              |
      |groups/ruleDefinitions/308/components/5001/options              |
      |groups/ruleDefinitions/309/components/5001/options              |
      |groups/ruleDefinitions/310/components/5001/options              |
      |groups/ruleDefinitions/310/components/5002/options              |
      |groups/ruleDefinitions/311/components/5001/options              |
      |groups/ruleDefinitions/312/components/5001/options              |
      |groups/ruleDefinitions/313/components/5001/options              |
      |groups/ruleDefinitions/314/components/5001/options              |
      |groups/ruleDefinitions/315/components/5001/options              |
      |groups/ruleDefinitions/316/components/5001/options              |
      |groups/ruleDefinitions/317/components/5001/options              |
      |groups/ruleDefinitions/318/components/5001/options              |
      |groups/ruleDefinitions/321/components/5001/options              |
      |groups/ruleDefinitions/322/components/5001/options              |
      |groups/ruleDefinitions/325/components/5001/options              |
      |groups/ruleDefinitions/325/components/5002/options              |
      |groups/ruleDefinitions/326/components/5001/options              |
      |groups/ruleDefinitions/328/components/5000/options              |
      |groups/ruleDefinitions/329/components/5000/options              |
      |groups/ruleDefinitions/329/components/5002/options              |
      |groups/ruleDefinitions/330/components/5000/options              |
      |groups/ruleDefinitions/331/components/5000/options              |
      |groups/ruleDefinitions/332/components/5001/options              |
      |groups/ruleDefinitions/333/components/5001/options              |
      |groups/ruleDefinitions/333/components/5002/options              |
      |groups/ruleDefinitions/334/components/5001/options              |
      |groups/ruleDefinitions/335/components/5001/options              |
      |groups/ruleDefinitions/336/components/5001/options              |
      |groups/ruleDefinitions/337/components/5001/options              |
      |groups/ruleDefinitions/338/components/5001/options              |
      |groups/ruleDefinitions/339/components/5003/options              |
      |groups/ruleDefinitions/340/components/5003/options              |
      |groups/ruleDefinitions/340/components/5004/options              |
      |groups/ruleDefinitions/341/components/5003/options              |
      |groups/ruleDefinitions/342/components/5003/options              |
      |groups/ruleDefinitions/343/components/5003/options              |
      |groups/ruleDefinitions/344/components/5003/options              |
      |groups/ruleDefinitions/344/components/5004/options              |
      |groups/ruleDefinitions/345/components/5003/options              |
      |groups/ruleDefinitions/346/components/5003/options              |
      |groups/ruleDefinitions/347/components/5001/options              |
      |groups/ruleDefinitions/348/components/5001/options              |
      |groups/ruleDefinitions/349/components/5001/options              |
      |groups/ruleDefinitions/350/components/5001/options              |
      |groups/ruleDefinitions/351/components/5001/options              |
      |groups/ruleDefinitions/352/components/5001/options              |
      |groups/ruleDefinitions/353/components/5001/options              |
      |groups/ruleDefinitions/354/components/5001/options              |
      |groups/ruleDefinitions/355/components/5001/options              |
      |groups/ruleDefinitions/356/components/5001/options              |
      |groups/ruleDefinitions/357/components/5001/options              |
      |groups/ruleDefinitions/358/components/5001/options              |
      |groups/ruleDefinitions/359/components/5001/options              |
      |groups/ruleDefinitions/359/components/5002/options              |
      |groups/ruleDefinitions/360/components/5001/options              |
      |groups/ruleDefinitions/361/components/5001/options              |
      |groups/ruleDefinitions/362/components/5001/options              |
      |groups/ruleDefinitions/363/components/5001/options              |
      |groups/ruleDefinitions/364/components/5001/options              |
      |groups/ruleDefinitions/365/components/5001/options              |
      |groups/ruleDefinitions/366/components/5001/options              |
      |groups/ruleDefinitions/367/components/5001/options              |
      |groups/ruleDefinitions/368/components/5001/options              |
      |groups/ruleDefinitions/369/components/5001/options              |
      |groups/ruleDefinitions/370/components/5001/options              |
      |groups/ruleDefinitions/370/components/5002/options              |
      |groups/ruleDefinitions/371/components/5001/options              |
      |groups/ruleDefinitions/372/components/5001/options              |
      |groups/ruleDefinitions/373/components/5001/options              |
      |groups/ruleDefinitions/374/components/5001/options              |
      |groups/ruleDefinitions/376/components/5001/options              |
      |groups/ruleDefinitions/377/components/5001/options              |
      |groups/ruleDefinitions/377/components/5002/options              |
      |groups/ruleDefinitions/378/components/5001/options              |
      |groups/ruleDefinitions/378/components/5002/options              |
      |groups/ruleDefinitions/379/components/5001/options              |
      |groups/ruleDefinitions/380/components/5001/options              |
      |groups/ruleDefinitions/381/components/5001/options              |
      |groups/ruleDefinitions/383/components/5001/options              |
      |groups/ruleDefinitions/384/components/5001/options              |
      |groups/ruleDefinitions/385/components/5002/options              |
      |groups/ruleDefinitions/386/components/5001/options              |
