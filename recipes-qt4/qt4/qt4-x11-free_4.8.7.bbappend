do_install_append() {
	sed -i 's@Libs.private:[ ]*-L[^ ]* @Libs.private: @g' ${D}${libdir}/pkgconfig/QtWebKit.pc
}
