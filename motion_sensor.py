import time
import smbus

i2c = smbus.SMBus(1)
address = 0x40

#	block2 = i2c.read_i2c_block_data(address, 0x5f, 2)

block1 = i2c.read_i2c_block_data(address, 0x5e, 2)

distance = ((block1[0])*16 + (block1[1]))/16/4	

	
#	distance = (((a0+a1+a2+a3+a4+a5+a6+a7)*16 + (b0+b1+b2+b3))/16/4
 #       if block2[5] == 1: distance = -1 

#	print("block1: %s" % block1)
#	print("block2: %s" % block2)
#	print("distance1: %s" % distance1)
#	print("distance2: %s" % distance2)
print("distance: %s" % distance)
#	print("distance4: %f" % distance4)
time.sleep(0.1)



