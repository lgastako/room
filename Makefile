all:
	@cat Makefile

# Build an x86 version and run in a simulator
runsim:
	lein fruit doall

rs: runsim
