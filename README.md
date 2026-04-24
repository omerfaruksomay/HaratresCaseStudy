# Case Açıklaması

## Main.java
- main metodunda Soru 1 ve Soru 2 arasında seçim yapılıp console uygulaması test edilir.
- switch-case yapısı içinde Case1.run() ve Case2.run() metodları çağrılır.

## Case1
- run metodu tüm işlemleri gerçekleştirir.
- getMaxCharacterCount maksimum karakter sayısını kullanıcıdan alan metottur.
- getSentence kullanıcıdan analiz edilecek cümleyi alan metottur.
- getCaseSensitivity kullanıcıdan analizde case sensitive olacak mı olmayacak mı bilgisini alan metottur.
- getTargetCharacter kullanıcıdan analizde hedef karakteri alan metotur.
- countCharacter kullanıcıya analizde hedef karakterden kaçtane olduğunu veren metottur. Büyük küçük harf şartı içinde bulunmaktadır.

## Case2
- Bu sorunun çözümünde Product, CartItem ve Cart olmak üzere 3 farklı data class vardır.
- Product data class'ı ürünlerin ismi, fiyatı, stok bilgisi, rating ve bu özelliklerin getter fonksiyonlarını tutar.
- Product.java'nın içerisnde stok takip metodları da bulunmkatadır. hasEnoughStock stoklarda yeterince var mı kontrolünü yapar. decreasseStock metodu ise ürün sepete eklendiğinde stoğu güncelleyen metottur. Son olarak printInfo metodu ürünün bilgilerini basar.
- CartItem data classı sepetteki tek tek ürünlerin özelliklerini, varsa indirim miktarı, adet bilgisi ve bu özelliklerin getter fonkisyonlarını tutar.
- CartItem.java içerisinde indirim metotları ve toplam fiyat bilgilerini veren metotlar bulunmaktadır. Bunların yanında aynı Product.java da olduğu gibi printInfo metotu da mevcuttur.
- Cart data class'ı sepetteki ürünleri liste olarak tutar.
- Cart.java içerisinde sepete yeni CartItem ekleme, sepetteki CartItem adeti sayısını verme, indirim uygulama ve sepetin toplam fiyatı gibi metotlar bulunur. Bunların yanında diğer data classlarda olduğu gibi printInfo metotu mevcuttur.
- Case2.java içerisinde tüm işlemler run() metodu ile çalışmaktadır.
- getProducts() kullanıcdan ürün sayısı ve ürünlerin bilgisini alıp eklenen tüm ürünleri döndüren metottur.
- sortProducts() kullanıcıdan alından sıralama ölçütü ile ürünleri sıralamada kullanılır. Burada Comparator pakedi kullanımıştır.
- addProdductsToCart() metotu ile sepete ürün ekleme işlemi gerçekleştirilir.
