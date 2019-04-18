<?php

namespace SlimBundle\Controller;

use SlimBundle\Entity\Assisstance;
use SlimBundle\Entity\Assisstant;
use SlimBundle\Entity\Conseil;
use SlimBundle\Entity\Produit;
use SlimBundle\Entity\Promotion;
use SlimBundle\Entity\Pub;
use AppBundle\Entity\User;
use SlimBundle\Form\AssisstanceType;
use SlimBundle\Form\AssisstantType;
use SlimBundle\Form\PromotionType;
use SlimBundle\Form\PubType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('@Slim/Default/index.html.twig');
    }
    public function indexfrontAction()
    {
        return $this->render('@Slim/Default/indexfront.html.twig');
    }
    public function singlepostAction()
    {
        return $this->render('@Slim/Front/single-post.html.twig');
    }
    public function portfolioAction()
    {
        $produits=$this->getDoctrine()->getRepository(Produit::class)->findAll();
        $promo=$this->getDoctrine()->getRepository(Promotion::class)->findAll();
        return $this->render('@Slim/Front/portfolio.html.twig',array('produits'=>$produits,'promo'=>$promo));
    }


    public function ajouterPromotionAction(Request $request)
    {
        $Promotion = new Promotion();

        $form = $this->createForm(PromotionType::class, $Promotion);
        $form->handleRequest($request);
        // $nouveauprix=$this->calculerPrix($request->get('pourcentage'),$request->get('prix'));

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();

            $repo=$this->getDoctrine()->getRepository(Produit::class);
            $post = $em->getRepository(Produit::class)->find($Promotion->getNomproduit());
            $prixprod=$post->getPrix() ;
            $pour=$Promotion->getPourcentage() ;
            $nouveaprix=$prixprod-(($prixprod*$pour)/100) ;
           $Promotion->setNouveauprix($nouveaprix) ;
            $em->persist($Promotion);


            $em->flush();
            return $this->redirectToRoute("afficherPromotion");
        }
        return $this->render("@Slim/Back/ajouterPromotion.html.twig",
            array('Promotion_form' => $form->createView()));
    }

    public function afficherPromotionAction()
    {
        $proj = $this->getDoctrine()->getRepository(Promotion::class)->findAll();

        return $this->render("@Slim/Back/afficherPromotion.html.twig", array('Promotion'=>$proj));
    }


    public function modifierPromotionAction($idpromotion,Request $request){
        $cars=$this->getDoctrine()->getRepository(Promotion::class)->find($idpromotion);
        $form=$this->createForm(PromotionType::class,$cars);
        $form->handleRequest($request);
        if ($form->isValid()){
            $e = $this->getDoctrine()->getManager();
            $e->flush();
            return $this->redirectToRoute("afficherPromotion");
        }
        return $this->render("@Slim/Back/modifierPromotion.html.twig",array("form_modifier"=>$form->createView()));
    }
    public function supprimerPromotionAction($idpromotion)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Promotion::class)->find($idpromotion);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherPromotion");
    }
    public function rechercherPromotionAction(Request $request)
    {
        $promotion =new Promotion();
        $nom=$request->get('nom');
        if(isset($nom)){
            $promotion=$this->getDoctrine()
                ->getRepository(Promotion::class)
                ->myfindAll($nom);
            return $this->render('@Slim/Back/rechercherPromotion.html.twig',array('promotions' => $promotion,));


        }
        return $this->render('@Slim/Back/rechercherPromotion.html.twig',array('promotions' => $promotion,));
    }
    public function sendmailAction()
    {
        $message = \Swift_Message::newInstance()->setSubject("Reservation")->setFrom("abdelkefianas@gmail.com")
            ->setTo("abdelkefianas@gmail.com")
            ->setBody("Une reservation a été effectuée");
        $this->get('mailer')->send($message);
    }
    public function ajouterPubAction(Request $request)
    {
        $Pub = new Pub();

        $form = $this->createForm(PubType::class, $Pub);
        $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($Pub);
            $em->flush();
            return $this->redirectToRoute("afficherPub");
        }
        return $this->render("@Slim/Back/ajouterPub.html.twig",
            array('Pub_form' => $form->createView()));
    }

    public function afficherPubAction()
    {
        $proj = $this->getDoctrine()->getRepository(Pub::class)->findAll();

        return $this->render("@Slim/Back/afficherPub.html.twig", array('Pub'=>$proj));
    }
    public function modifierPubAction($idpublicite,Request $request){
        $cars=$this->getDoctrine()->getRepository(Pub::class)->find($idpublicite);
        $form=$this->createForm(PubType::class,$cars);
        $form->handleRequest($request);
        if ($form->isValid()){
            $e = $this->getDoctrine()->getManager();
            $e->flush();
            return $this->redirectToRoute("afficherPub");
        }
        return $this->render("@Slim/Back/modifierPub.html.twig",array("form_modifier"=>$form->createView()));
    }
    public function supprimerPubAction($idpublicite)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Pub::class)->find($idpublicite);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherPub");
    }


    public function afficherUserAction()
    {
        $proj = $this->getDoctrine()->getRepository(Pub::class)->findAll();

        return $this->render("@Slim/Back/afficherUser.html.twig", array('User'=>$proj));
    }
}
