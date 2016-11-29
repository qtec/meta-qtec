SUMMARY = "XXD - make a hexdump or do the reverse."
SECTION = "console/utils"
LICENSE = "vim"
LIC_FILES_CHKSUM = "file://../../runtime/doc/uganda.txt;md5=c74ec0ada9a68354f9461e81d3596f61"

SRC_URI = "git://github.com/vim/vim.git"
SRCREV = "758535a1df4c5e86b45dddf12db2a54dea28ca40"

BBCLASSEXTEND = "native"

S = "${WORKDIR}/git/src/xxd"

do_install() {
	install -d ${D}${bindir}
	install -m 755 xxd ${D}${bindir}/
}
