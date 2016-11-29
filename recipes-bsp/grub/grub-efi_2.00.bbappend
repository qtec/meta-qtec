GRUB_BUILDIN = "boot linux ext2 fat part_msdos part_gpt normal efi_gop iso9660 reboot lspci ls datetime loadenv search lvm help memrw iorw gfxterm png efi_uga font video_bochs video_cirrus all_video"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-grub-core-fs-ext2.c-Experimental-support-for-64-bit.patch"

BUILD_LDFLAGS += "-no-pie"
