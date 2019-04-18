<?php
/**
 * Created by PhpStorm.
 * User: Laptop Center
 * Date: 20/03/2019
 * Time: 20:58
 */

namespace SlimBundle\Controller;

use SlimBundle\Entity\Mail;


use SlimBundle\Form\MailType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;



class MailController extends Controller
{
    public function sendMailAction (Request $request)
    {

        $mail=new Mail();
        $form = $this->createForm(MailType::class, $mail);
        $form->handleRequest($request);
        if($form->isSubmitted()&&$form->isValid()) {
            $subject = $mail->getSubject();
            $mail = $mail->getMail();
            $object = $request->get('form')['objet'];
            $username = 'alihachem.tahar@esprit.tn';
            $message = \Swift_Message::newInstance()
                ->setSubject($subject)
                ->setFrom($username)
                ->setTo($mail)
                ->setBody($object);
            $this->get('mailer')->send($message);
            $this->get('session')->getFlashBag()->add('notice', 'Message envoyé');
        }
        return $this->render("@Slim/mail/mail.html.twig",
            array("form" => $form->createView()));






    }



}




