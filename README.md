# Android - Webview
Android - Webview

İstediğiniz herhangi bir web sitesini android uygulama üzerinde göstermek için basit bir örnek.

AndroidManifest.xml dosyasına internet iznini eklemeyi unutmayın.

        <uses-permission android:name="android.permission.INTERNET"/>

Android'in değişen güvenlik güncellemesi ile Android 6.0 (SdkVersion 23) üstü için AndroidManifest.xml dosyasına aşağıdaki eklenti eklenmeli, 
res dosyası içine xml dosyası oluşturulmalı ve network_security_config.xml oluşturularak güvenli domain (erişilmek istenilen web sitesi) belirtilmelidir.

res dosyasına xml klasörü oluşturulur,
xml klasörü içine network_security_config.xml oluşturulur,
network_security_config.xml içerisine aşağıdaki kısım eklenir.

        <?xml version="1.0" encoding="utf-8"?>
        
            <network-security-config>
            
                <domain-config cleartextTrafficPermitted="true">
                
                  <domain includeSubdomains="true">ulkeralihan.com</domain>
                  
                </domain-config>
                
            </network-security-config>


AndroidManifest.xml dosyasına güvenlik önlemleri için aşağıdaki kod eklenir.

        android:theme="@style/Theme.Website"
        
        android:usesCleartextTraffic="true"
        android:networkSecurityConfig="@xml/network_security_config"
        tools:targetApi="n">
        
        <activity android:name=".MainActivity">
        
