# Case Açıklaması

## Main.java
- main metodunda Soru 1 ve Soru 2 arasında seçim yapılarak konsol uygulaması test edilir.
- switch-case yapısı içinde Case1.run() ve Case2.run() metodları çağrılır.

## Case1
- run metodu tüm işlemleri gerçekleştirir.
- getMaxCharacterCount maksimum karakter sayısını kullanıcıdan alan metottur.
- getSentence kullanıcıdan analiz edilecek cümleyi alan metottur.
- getCaseSensitivity kullanıcıdan analizde büyük/küçük harf duyarlılığı bilgisini alan metottur.
- getTargetCharacter kullanıcıdan analiz edilecek hedef karakteri alan metottur.
- countCharacter hedef karakterin cümlede kaç defa geçtiğini hesaplayan metottur. Büyük/küçük harf duyarlılığına göre çalışır.

## Case2
- Bu sorunun çözümünde Product, CartItem ve Cart olmak üzere 3 farklı data class bulunmaktadır.

### Product
- Ürünün adı, fiyatı, stok bilgisi ve değerlendirme puanını (rating) tutar.
- Getter metotları içerir.
- hasEnoughStock metodu stokta yeterli ürün olup olmadığını kontrol eder.
- decreaseStock metodu ürün sepete eklendiğinde stok bilgisini günceller.
- printInfo metodu ürün bilgilerini ekrana yazdırır.

### CartItem
- Sepetteki ürünün adet bilgisi, birim fiyatı ve varsa indirimli fiyatını tutar.
- Getter metotları içerir.
- Toplam fiyat hesaplama ve indirim işlemlerine ait metotlar içerir.
- printInfo metodu ürün bilgilerini ekrana yazdırır.

### Cart
- Sepetteki ürünleri liste olarak tutar.
- Sepete ürün ekleme, ürün sayısını alma, indirim uygulama ve toplam fiyat hesaplama metotlarını içerir.
- printInfo metodu sepet içeriğini yazdırır.

### Case2.java
- Tüm işlemler run() metodu içerisinde yürütülür.
- getProducts() kullanıcıdan ürün bilgilerini alarak ürün listesini oluşturur.
- sortProducts() kullanıcıdan alınan kritere göre ürünleri sıralar. Comparator kullanılmıştır.
- addProductsToCart() metodu ile sepete ürün ekleme işlemleri gerçekleştirilir.
