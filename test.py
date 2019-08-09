import tensorflow as tf

first = tf.constant([1,2],dtype=tf.float32,name="input")

result = tf.add(first,first,name="output")

sess = tf.Session();
sess.run(tf.initialize_all_variables())

output_graph_def = tf.graph_util.convert_variables_to_constants(sess, sess.graph_def,output_node_names=['output'])

with tf.gfile.FastGFile('F:/android_tensorflow.pb', mode='wb') as f:
	f.write(output_graph_def.SerializeToString())
