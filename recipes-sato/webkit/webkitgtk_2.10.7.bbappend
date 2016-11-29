DEPENDS += "freetype"
#Seems like there is an out of order error build dependency. Since no one
#uses this instrospection remove it until we update yocto
#error parsing file /var/lib/jenkins/workspace/qt5022-cesium-clean/build/tmp/work/bobcat_64-poky-linux/webkitgtk/2.10.7-r0/build/WebKit2-4.0.gir: Error on line 1573 char 28: Document ended unexpectedly inside an attribute name
EXTRA_OECMAKE_append = " -DENABLE_INTROSPECTION=OFF -DENABLE_GTKDOC=OFF"
