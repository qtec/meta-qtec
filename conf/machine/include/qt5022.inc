include conf/machine/include/ia32-base.inc
require conf/machine/include/tune-amd-bobcat.inc

MACHINE_FEATURES += "wifi efi pcbios acpi"
IMAGE_FSTYPES = "tar.gz"

PREFERRED_PROVIDER_virtual/kernel = "linux-qtec"
PREFERRED_RPROVIDER_java2-runtime = "openjre-8"
PREFERRED_PROVIDER_virtual/java-initial-native = "cacao-initial-native"
PREFERRED_PROVIDER_virtual/java-native = "cacao-native"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "grub-files"

PREFERRED_VERSION_linux-libc-headers = "4.8.%"

XSERVER = " \
	    xserver-xorg \
	    xf86-input-mouse \
	    xf86-input-keyboard \
	    xf86-input-evdev \
	    xserver-xorg-extension-dri \
	    xserver-xorg-extension-dri2 \
	    xserver-xorg-extension-extmod \
	    xserver-xorg-extension-dbe \
	    xserver-xorg-module-libint10 \
	    "

MACHINE_EXTRA_RRECOMMENDS += " linux-firmware-iwlwifi-6000g2a-5 linux-firmware-iwlwifi-6000g2b-6 v86d kernel-firmware kernel-modules clinfo"

SERIAL_CONSOLE = ""

GLIBC_ADDONS = "nptl"

EXTRA_OECONF_append_pn-matchbox-panel-2 = " --with-battery=acpi"

KERNEL_IMAGETYPE = "bzImage"
